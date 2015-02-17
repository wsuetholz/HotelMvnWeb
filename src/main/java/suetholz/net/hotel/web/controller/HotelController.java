/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suetholz.net.hotel.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import suetholz.net.hotel.web.model.dbservice.HotelService;
import suetholz.net.hotel.web.model.entities.Hotel;

/**
 *
 * @author wsuetholz
 */
public class HotelController extends HttpServlet {

    // Error page
    private static final String ERROR_PAGE = "/error.jsp";
    private static final String HOTEL_LIST_PAGE = "/hotels.jsp";
    private static final String HOTEL_UPDATE_PAGE = "/hotel.jsp";
    
    // QueryString param for controller actions to delegate
    private static final String ACTION_KEY = "action";
    
    // Action Types
    private static final String FIND_ALL_ACTION = "findAll";
    private static final String FIND_ONE_ACTION = "findOne";
    private static final String DOCHANGES_ACTION = "doChanges";
    private static final String STORE_ACTION = "store";
   
    private static final String ADD_EDIT_BUTTON = "btnAddEdit";
    private static final String DELETE_BUTTON = "btnDelete";
    private static final String CANCEL_BUTTON = "btnCancel";
    private static final String SAVE_BUTTON = "btnSave";
    
    // Error messages...
    private static final String ACTION_UNKNOWN_MSG =
        "Sorry, unable to complete this request because the action is unknown.";
   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	String destination = ERROR_PAGE;
	
	response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter(ACTION_KEY);

	HotelService hotelService = new HotelService();
	
	try {
            if(FIND_ALL_ACTION.equals(action)) {
		List<Hotel> hotels = hotelService.getAllHotels();
                request.setAttribute("hotels", hotels);
                destination = HOTEL_LIST_PAGE;

            } else if(FIND_ONE_ACTION.equals(action)) {
            
            } else if(DOCHANGES_ACTION.equals(action)) {
                String addEdit = request.getParameter(ADD_EDIT_BUTTON);
		String delete = request.getParameter(DELETE_BUTTON);
                if(addEdit != null) {
                    // must have clicked the Add/Edit button
                    String[] ids = request.getParameterValues("id");
                    if(ids == null) {
                        // must be a new record
                        Hotel hotel = new Hotel();
                        request.setAttribute("hotel", hotel);
                    } else {
                        // get the first item only for update
                        Hotel hotel = hotelService.getHotelById(ids[0]);
                        request.setAttribute("hotel", hotel);
                    }
                    destination = HOTEL_UPDATE_PAGE;
                } else if (delete != null) {
                    // must have clicked the delete button
                    String[] ids = request.getParameterValues("id");
                    hotelService.deleteHotelsByIds(ids);
                    List<Hotel> hotels = hotelService.getAllHotels();
                    request.setAttribute("hotels", hotels);
                    destination = HOTEL_LIST_PAGE;
                } else {
                    List<Hotel> hotels = hotelService.getAllHotels();
                    request.setAttribute("hotels", hotels);
                    destination = HOTEL_LIST_PAGE;		
		}

            } else if(STORE_ACTION.equals(action)) {
                String save = request.getParameter(SAVE_BUTTON);
                if(save != null) {
                    // must have clicked the Save button
                    String id = request.getParameter("inputId");
                    Integer objId = (id == null || id.equals("null") || id.length() == 0) ? null : new Integer(id);
                    String hotelName = request.getParameter("inputName");
                    String street = request.getParameter("inputStreet");
                    String city = request.getParameter("inputCity");
                    String state = request.getParameter("inputState");
                    String postalCode = request.getParameter("inputPostalCode");
                    String notes = request.getParameter("inputNotes");
		    
		    if (objId == null || objId.equals(new Integer(0))) {
			Hotel hotel =
				new Hotel(objId,hotelName, street, city, state, postalCode, notes);
			hotelService.insertHotel(hotel);
		    } else {
			Hotel hotel =
				new Hotel(objId,hotelName, street, city, state, postalCode, notes);
			hotelService.updateHotel(hotel);
			
		    }
                    List<Hotel> hotels = hotelService.getAllHotels();
                    request.setAttribute("hotels", hotels);
                    destination = HOTEL_LIST_PAGE;		

                } else {
                    // must have clicked the Cancel button
                    List<Hotel> hotels = hotelService.getAllHotels();
                    request.setAttribute("hotels", hotels);
                    destination = HOTEL_LIST_PAGE;		
                }

            // If we get to here, no known action was retrieved from
            // the FrontController.
            } else {
                destination = ERROR_PAGE;
                request.setAttribute("errorMsg", ACTION_UNKNOWN_MSG);
            }
        } catch(Exception e) {
            destination = ERROR_PAGE;
            request.setAttribute("errorMsg", e);
        }

        // Redirect to sub-controller
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);	
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
