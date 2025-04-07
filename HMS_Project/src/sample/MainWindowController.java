
package sample;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.w3c.dom.events.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class MainWindowController implements Initializable {

    @FXML
    private Button logoutButton;
    @FXML
    private TabPane tabelsTabPane;
    @FXML
    private Tab bookingsTab;
    @FXML
    private TableView<Bookings> bookingsTable;
    @FXML
    private TableColumn<Bookings, Integer> bookingIDColumn;
    @FXML
    private TableColumn<Bookings, Date> bookingDateColumn;
    @FXML
    private TableColumn<Bookings, Integer> bookingDOFSColumn;
    @FXML
    private TableColumn<Bookings, Integer> bookingGuestIDColumn;
    @FXML
    private TableColumn<Bookings, String> bookingFNameColumn;
    @FXML
    private TableColumn<Bookings, String> bookingLNameColumn;
    @FXML
    private TableColumn<Bookings, Date> bookingCheckINColumn;
    @FXML
    private TableColumn<Bookings, Date> bookingCheckOUTColumn;
    @FXML
    private TableColumn<Bookings, String> bookingHotelNameColumn;
    @FXML
    private TableColumn<Bookings, Integer> bookingHotelIDColumn;
    @FXML
    private TableColumn<Bookings, Integer> bookingRoomIDColumn;
    @FXML
    private TableColumn<Bookings, Integer> bookingPaymentColumn;
    @FXML
    private TableColumn<Bookings, Integer> bookingCheckedOutColumn;
    @FXML
    private TableView<Guest> guestTable;
    @FXML
    private TableColumn<Guest, Integer> guestIDColumn;
    @FXML
    private TableColumn<Guest, String> guestNCColumn;
    @FXML
    private TableColumn<Guest, String> guestFNColumn;
    @FXML
    private TableColumn<Guest, String> guestLNColumn;
    @FXML
    private TableColumn<Guest, String> guestCNColumn;
    @FXML
    private TableColumn<Guest, Integer> guestTBHColumn;
    @FXML
    private TableColumn<Guest, String> guestEAColumn;
    @FXML
    private TableColumn<Guest, String> guestADDLineColumn;
    @FXML
    private TableColumn<Guest, String> guestCityColumn;
    @FXML
    private TableColumn<Guest, String> guestStateColumn;
    @FXML
    private TableColumn<Guest, String>guestCountryColumn;
    @FXML
    private TableColumn<Guest, String> guestZipCodeColumn;
    @FXML
    private TableView<Room> roomsTable;
    @FXML
    private TableColumn<Room, Integer> roomsRoomIDColumn;
    @FXML
    private TableColumn<Room, Integer>  roomsRoomNumberColumn;
    @FXML
    private TableColumn<Room, Integer>  roomsRoomTypeColumn;
    @FXML
    private TableColumn<Room, Integer>  roomsHotelIDColumn;
    @FXML
    private TableView<Hotel> hotelTable;
    @FXML
    private TableColumn<Hotel, Integer> hotelHotelIDColumn;
    @FXML
    private TableColumn<Hotel, String> hotelHotelNameColumn;
    @FXML
    private TableColumn<Hotel, String> hotelCNColumn;
    @FXML
    private TableColumn<Hotel, String> hotelEAColumn;
    @FXML
    private TableColumn<Hotel, String> hotelWebsiteColumn;
    @FXML
    private TableColumn<Hotel, String> hotelDESCColumn;
    @FXML
    private TableColumn<Hotel, Integer> hotelRCapacityColumn;
    @FXML
    private TableColumn<Hotel, String> hotelADDLineColumn;
    @FXML
    private TableColumn<Hotel, String> hotelCityColumn;
    @FXML
    private TableColumn<Hotel, String> hotelStateColumn;
    @FXML
    private TableColumn<Hotel, String> hotelCountryColumn;
    @FXML
    private TableColumn<Hotel, String> hotelZipCodeColumn;
    @FXML
    private TableView<Service> servicesTable;
    @FXML
    private TableColumn<Service, Integer> servicesSIDColumn;
    @FXML
    private TableColumn<Service, String> servicesSNameColumn;
    @FXML
    private TableColumn<Service, String> servicesSDESCColumn;
    @FXML
    private TableColumn<Service, Integer> servicesSCostColumn;
    @FXML
    private TableColumn<Service, Integer> servicesHotelIDColumn;
    @FXML
    private TableView<ServiceUsed> servicesUsedTable;
    @FXML
    private TableColumn<ServiceUsed, Integer> sUsedIDColumn;
    @FXML
    private TableColumn<ServiceUsed, Integer> sUsedServiceNameColumn;
    @FXML
    private TableColumn<ServiceUsed, Integer> sUsedServiceIDColumn;
    @FXML
    private TableColumn<ServiceUsed, Integer> sUsedBookingIDColumn;
    @FXML
    private DatePicker mostPGuestsFromDateDP;
    @FXML
    private DatePicker mostPGuestsToDateDP;
    @FXML
    private Button mostPGuestsUpdateBTN;
    @FXML
    private TableView<ProfitableGuest> mostPGuestsTable;
    @FXML
    private TableColumn<ProfitableGuest, Integer> mostPGuestsGuestIDColumn;
    @FXML
    private TableColumn<ProfitableGuest, String> mostPGuestsGFNameColumn;
    @FXML
    private TableColumn<ProfitableGuest, String> mostPGuestsGLNameColumn;
    @FXML
    private TableColumn<ProfitableGuest, Integer> mostPGuestsTotalColumn;
    @FXML
    private TableColumn<ProfitableGuest, Date> mostPGuestsFromDateColumn;
    @FXML
    private TableColumn<ProfitableGuest, Date> mostPGuestsToDateColumn;
    @FXML
    private DatePicker mostUsedRoomsFromDateDP;
    @FXML
    private DatePicker mostUsedRoomsToDateDP;
    @FXML
    private Button mostUsedRoomsUpdateBTN;
    @FXML
    private TableView<MostUsedRoom> mostUsedRoomsTable;
    @FXML
    private TableColumn<MostUsedRoom, Integer> mostUsedRoomsRoomIDColumn;
    @FXML
    private TableColumn<MostUsedRoom, Integer> mostUsedRoomsTimesUsedColumn;
    @FXML
    private TableColumn<MostUsedRoom, Date> mostUsedRoomsFromDateColumn;
    @FXML
    private TableColumn<MostUsedRoom, Date> mostUsedRoomsToDateColumn;
    @FXML
    private DatePicker mostUsedHotelsFromDateDP;
    @FXML
    private DatePicker mostUsedHotelsToDateDP;
    @FXML
    private Button mostUsedHotelsUpdateBTN;
    @FXML
    private TableView<MostUsedHotel> mostUsedHotelsTable;
    @FXML
    private TableColumn<MostUsedHotel, Integer> mostUsedHotelsHotelIDColumn;
    @FXML
    private TableColumn<MostUsedHotel, Integer> mostUsedHotelsTimesUsedColumn;
    @FXML
    private TableColumn<MostUsedHotel, Date> mostUsedHotelsFromDateColumn;
    @FXML
    private TableColumn<MostUsedHotel, Date> mostUsedHotelsToDateColumn;
    @FXML
    private DatePicker mostPCityFromDateDP;
    @FXML
    private DatePicker mostPCityToDateDP;
    @FXML
    private Button mostPCityUpdateBTN;
    @FXML
    private TableView<ProfitableCity> mostPCityTable;
    @FXML
    private TableColumn<ProfitableCity, String> mostPCityNameColumn;
    @FXML
    private TableColumn<ProfitableCity, Integer> mostPCityTimesColumn;
    @FXML
    private TableColumn<ProfitableCity, Date> mostPCityFromDateColumn;
    @FXML
    private TableColumn<ProfitableCity, Date> mostPCityToDateColumn;
    @FXML
    private DatePicker mostUsedServicesFromDateDP;
    @FXML
    private DatePicker mostUsedServicesToDateDP;
    @FXML
    private Button mostUsedServicesUpdateBTN;
    @FXML
    private TableView<MostUsedService> mostUsedServicesTable;
    @FXML
    private TableColumn<MostUsedService, String> mostUsedServicesSNameColumn;
    @FXML
    private TableColumn<MostUsedService, Integer> mostUsedServicesTimesColumn;
    @FXML
    private TableColumn<MostUsedService, Date> mostUsedServicesFromDateColumn;
    @FXML
    private TableColumn<MostUsedService, Date> mostUsedServicesToDateColumn;
    @FXML
    private VBox mostUsedRoomsDateENDDP;
    @FXML
    private DatePicker unusedHotelsFromDateDP;
    @FXML
    private DatePicker unusedHotelsToDateDP;
    @FXML
    private TextField unusedHotelsGuestIDTF;
    @FXML
    private Button unusedHotelsUpdateBTN;
    @FXML
    private TableView<NotUsedHotel> unusedHotelsTable;
    @FXML
    private TableColumn<NotUsedHotel, Integer> unusedHotelsGuestIDColumn;
    @FXML
    private TableColumn<NotUsedHotel, String> unusedHotelsCityNameColumn;
    @FXML
    private TableColumn<NotUsedHotel, Integer> unusedHotelsHotelIDColumn;
    @FXML
    private TableColumn<NotUsedHotel, Date> unusedHotelsFromDateColumn;
    @FXML
    private TableColumn<NotUsedHotel, Date> unusedHotelsToDateColumn;
    @FXML
    private TabPane insertDataTabPane;
    @FXML
    private TextField addguestIDTF;
    @FXML
    private TextField addguestNCTF;
    @FXML
    private TextField addguestFNameTF;
    @FXML
    private TextField addguestLNameTF;
    @FXML
    private TextField addGuestCNTF;
    @FXML
    private TextField addguestTBHTF;
    @FXML
    private TextField addguestEAddressTF;
    @FXML
    private TextField addguestCountryTF;
    @FXML
    private TextField addguestStateTF;
    @FXML
    private TextField addguestCityTF;
    @FXML
    private TextField addguestAddressTF;
    @FXML
    private TextField addguestZipcodeTF;
    @FXML
    private Button addGuestOKBTN;
    @FXML
    private Button addGuestEDTBTN;
    @FXML
    private Button addGuestDLBTN;
    @FXML
    private Label guest_node1;
    @FXML
    private TextField addBookingIDTF;
    @FXML
    private DatePicker addBookingDP;
    @FXML
    private TextField addBookingDOSTF;
    @FXML
    private DatePicker addBookingCINDP;
    @FXML
    private DatePicker addBookingCOUTDP;
    @FXML
    private TextField addBookingHIDTF;
    @FXML
    private TextField addBookingGuestIDTF;
    @FXML
    private TextField addBookingRoomIDTF;
    @FXML
    private TextField addBookingTotalPaymentTF;
    @FXML
    private TextField addBookingCheckedOut;
    @FXML
    private Button addBookingOKBTN;
    @FXML
    private Button addBookingEDTBTN;
    @FXML
    private Button addBookingDLBTN;
    @FXML
    private TextField addRoomIDTF;
    @FXML
    private TextField addRoomRNTF;
    @FXML
    private TextField addRoomRTTF;
    @FXML
    private TextField addRoomHIDTF;
    @FXML
    private Button addRoomOKBTN;
    @FXML
    private Button addRoomEDTBTN;
    @FXML
    private Button addRoomDLBTN;
    @FXML
    private TextField addHotelHIDTF;
    @FXML
    private TextField addHotelHNameTF;
    @FXML
    private TextField addHotelCNTF;
    @FXML
    private TextField addHotelEATF;
    @FXML
    private TextField addHotelWSTF;
    @FXML
    private TextField addHotelDESCTF;
    @FXML
    private TextField addHotelRoomCTF;
    @FXML
    private TextField addHotelAddLineTF;
    @FXML
    private TextField addHotelCityTF;
    @FXML
    private TextField addHotelStateTF;
    @FXML
    private TextField addHotelCountryTF;
    @FXML
    private TextField addHotelZipCodeTF;
    @FXML
    private Button addHotelOKBTN;
    @FXML
    private Button addHotelEDTBTN;
    @FXML
    private Button addHotelDLBTN;
    @FXML
    private TextField addServiceUSEDHIDTF;
    @FXML
    private TextField addServiceUSEDHotelServiceIDTF;
    @FXML
    private TextField addServiceUSEDBookingIDTF;
    @FXML
    private Button addServiceUSEDOKBTN;
    @FXML
    private Button addServiceUSEDEDTBTN;
    @FXML
    private Button addServiceUSEDDLBTN;
    /**
     * Initializes the controller class.
     */

    Connection connection;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    DatabaseConnection databaseConnection = new DatabaseConnection();
     connection  = databaseConnection.getConnection();
     showBookings();
     showGuest();
     showRoom();

    }

    public void initSessionID(final LoginManager loginManager, String sessionID) {

        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                loginManager.logout();
            }
        });
    }

    public ObservableList<Bookings> getBookingsList(){
        ObservableList<Bookings> bookingsList = FXCollections.observableArrayList();

        String query = "select booking_id,booking_date,duration_of_stay,guests_guest_id,first_name,last_name,check_in_date,check_out_date,\n" +
                "       hotel_name,hotel_hotel_id,room_room_id,total_payment,checked_out\n" +
                "\n" +
                "from guests g join bookings b join hotel h on b.hotel_hotel_id = h.hotel_id and g.guest_id = b.guests_guest_id order by booking_id;";

    Statement statement;
    ResultSet resultSet;

     try {
    statement = connection.createStatement();
    resultSet = statement.executeQuery(query);
    Bookings bookings = null;
    
    while (resultSet.next()){
        
        bookings = new Bookings (resultSet.getInt("booking_id"), resultSet.getDate("booking_date"),
                        resultSet.getInt("duration_of_stay"),resultSet.getInt("guests_guest_id"),
                        resultSet.getString("first_name"), resultSet.getString("last_name"),
                        resultSet.getDate("check_in_date"),resultSet.getDate("check_out_date"),
                        resultSet.getString("hotel_name"),resultSet.getInt("hotel_hotel_id"),
                        resultSet.getInt("room_room_id"),resultSet.getInt("total_payment"),
                        resultSet.getInt("checked_out"));
                        bookingsList.add(bookings);

    }

     } catch (Exception exception){
         exception.printStackTrace();

     }
     return bookingsList;

}

    public void showBookings(){

        ObservableList<Bookings> list = getBookingsList();

   bookingIDColumn.setCellValueFactory(new PropertyValueFactory<Bookings,Integer>("bookingsID"));
   bookingDateColumn.setCellValueFactory(new PropertyValueFactory<Bookings,Date>("bookingsDate"));
   bookingDOFSColumn.setCellValueFactory(new PropertyValueFactory<Bookings,Integer>("bookingsDOFS"));
   bookingGuestIDColumn.setCellValueFactory(new PropertyValueFactory<Bookings,Integer>("bookingsGuestID"));
   bookingFNameColumn.setCellValueFactory(new PropertyValueFactory<Bookings,String>("bookingsFName"));
   bookingLNameColumn.setCellValueFactory(new PropertyValueFactory<Bookings,String>("bookingsLName"));
   bookingCheckINColumn.setCellValueFactory(new PropertyValueFactory<Bookings,Date>("bookingsCheckINDate"));
   bookingCheckOUTColumn.setCellValueFactory(new PropertyValueFactory<Bookings,Date>("bookingsCheckOUTDate"));
   bookingHotelNameColumn.setCellValueFactory(new PropertyValueFactory<Bookings,String>("bookingsHotelName"));
   bookingHotelIDColumn.setCellValueFactory(new PropertyValueFactory<Bookings,Integer>("bookingsHotelID"));
   bookingRoomIDColumn.setCellValueFactory(new PropertyValueFactory<Bookings,Integer>("bookingsRoomID"));
   bookingPaymentColumn.setCellValueFactory(new PropertyValueFactory<Bookings,Integer>("bookingsTotalPayment"));
   bookingCheckedOutColumn.setCellValueFactory(new PropertyValueFactory<Bookings,Integer>("bookingsCheckedOut"));

    bookingsTable.setItems(list);


}
    @FXML
    private void insertBooking() {


        String query = "INSERT INTO bookings (booking_date,duration_of_stay,check_in_date,check_out_date," +
                "hotel_hotel_id,guests_guest_id,room_room_id,total_payment,checked_out) VALUES (?,?,?,?,?,?,?,?,?)";

        LocalDate bookingDate = addBookingDP.getValue();
        int dos = Integer.parseInt(addBookingDOSTF.getText());
        LocalDate checkInDate = addBookingCINDP.getValue();
        LocalDate checkOutDate = addBookingCOUTDP.getValue();
        int hotelID = Integer.parseInt(addBookingHIDTF.getText());
        int guestID = Integer.parseInt(addBookingGuestIDTF.getText());
        int roomID = Integer.parseInt(addBookingRoomIDTF.getText());
        int totalPayment = Integer.parseInt(addBookingTotalPaymentTF.getText());
        int checkedOut = Integer.parseInt(addBookingCheckedOut.getText());



        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(query);
            statement.setDate(1,Date.valueOf(bookingDate));
            statement.setInt(2,dos);
            statement.setDate(3,Date.valueOf(checkInDate));
            statement.setDate(4,Date.valueOf(checkOutDate));
            statement.setInt(5,hotelID);
            statement.setInt(6,guestID);
            statement.setInt(7,roomID);
            statement.setInt(8,totalPayment);
            statement.setInt(9,checkedOut);

            statement.executeUpdate();

        } catch (Exception exception){
            exception.printStackTrace();
        }

        showBookings();

    }

    @FXML
    private void updateBooking(){
        String query  = "UPDATE bookings SET booking_date = ?, duration_of_stay = ?, check_in_date = ?, check_out_date = ?,"
                        + " hotel_hotel_id = ?, guests_guest_id = ? ,room_room_id = ? , total_payment = ? , checked_out = ? " +
                " WHERE booking_id = " + Integer.parseInt(addBookingIDTF.getText());

        LocalDate bookingDate = addBookingDP.getValue();
        int dos = Integer.parseInt(addBookingDOSTF.getText());
        LocalDate checkInDate = addBookingCINDP.getValue();
        LocalDate checkOutDate = addBookingCOUTDP.getValue();
        int hotelID = Integer.parseInt(addBookingHIDTF.getText());
        int guestID = Integer.parseInt(addBookingGuestIDTF.getText());
        int roomID = Integer.parseInt(addBookingRoomIDTF.getText());
        int totalPayment = Integer.parseInt(addBookingTotalPaymentTF.getText());
        int checkedOut = Integer.parseInt(addBookingCheckedOut.getText());



        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(query);
            statement.setDate(1,Date.valueOf(bookingDate));
            statement.setInt(2,dos);
            statement.setDate(3,Date.valueOf(checkInDate));
            statement.setDate(4,Date.valueOf(checkOutDate));
            statement.setInt(5,hotelID);
            statement.setInt(6,guestID);
            statement.setInt(7,roomID);
            statement.setInt(8,totalPayment);
            statement.setInt(9,checkedOut);

            statement.executeUpdate();

        } catch (Exception exception){
            exception.printStackTrace();
        }

        showBookings();


    }

    @FXML
    private void deleteBooking(){
        String query = "DELETE FROM bookings WHERE booking_id =" + Integer.parseInt(addBookingIDTF.getText());
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (Exception exception){
            exception.printStackTrace();
        }

        showBookings();

    }

    @FXML
    private void handleClickedOnBookingTable (){
    Bookings bookings = bookingsTable.getSelectionModel().getSelectedItem();
    addBookingIDTF.setText(String.valueOf(bookings.getBookingsID()));
    addBookingDOSTF.setText(String.valueOf(bookings.getBookingsDOFS()));
    addBookingDP.setValue(bookings.getBookingsDate().toLocalDate());
    addBookingCINDP.setValue(bookings.getBookingsCheckINDate().toLocalDate());
    addBookingCOUTDP.setValue(bookings.getBookingsCheckOUTDate().toLocalDate());
    addBookingHIDTF.setText(String.valueOf(bookings.getBookingsHotelID()));
    addBookingGuestIDTF.setText(String.valueOf(bookings.getBookingsGuestID()));
    addBookingRoomIDTF.setText(String.valueOf(bookings.getBookingsRoomID()));
    addBookingTotalPaymentTF.setText(String.valueOf(bookings.getBookingsTotalPayment()));
    addBookingCheckedOut.setText(String.valueOf(bookings.getBookingsCheckedOut()));
}





    public ObservableList<Guest> getGuestList(){
        ObservableList<Guest> guestsList = FXCollections.observableArrayList();

        String query = "select guest_id,national_code,first_name,last_name,contact_number,times_been_here"+
                        ",email_address,address_line,city,state,country,postal_code" +
                        " from guests; ";

        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            Guest guest = null;

            while (resultSet.next()){

                guest = new Guest (resultSet.getInt("guest_id"), resultSet.getString("national_code"),
                                     resultSet.getString("first_name"),resultSet.getString("last_name"),
                                      resultSet.getString("contact_number"),resultSet.getInt("times_been_here"),
                                        resultSet.getString("email_address"),resultSet.getString("address_line")
                                            ,resultSet.getString("city"),resultSet.getString("state")
                                        ,resultSet.getString("country"),resultSet.getString("postal_code"));
                guestsList.add(guest);

            }

        } catch (Exception exception){
            exception.printStackTrace();

        }
        return guestsList;

    }





    public void showGuest(){

        ObservableList<Guest> list = getGuestList();

        guestIDColumn.setCellValueFactory(new PropertyValueFactory<Guest,Integer>("guestID"));
        guestNCColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("guestNC"));
        guestFNColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("guestFName"));
        guestLNColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("guestLName"));
        guestCNColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("guestCN"));
        guestTBHColumn.setCellValueFactory(new PropertyValueFactory<Guest,Integer>("guestTBH"));
        guestEAColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("guestEA"));
        guestADDLineColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("guestALine"));
        guestCityColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("guestCity"));
        guestStateColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("guestState"));
        guestCountryColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("guestCountry"));
        guestZipCodeColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("guestZipCode"));



        guestTable.setItems(list);


    }



    @FXML
    private void insertGuest() {


        String query = "INSERT INTO guests (national_code,first_name,last_name,contact_number,times_been_here" +
                        ",email_address,address_line,city,state,country,postal_code) VALUES (?,?,?,?,?,?,?,?,?,?,?)";


        String nationalCode = addguestNCTF.getText();
        String firstName = addguestFNameTF.getText();
        String lastName = addguestLNameTF.getText();
        String number = addGuestCNTF.getText();
        int times = Integer.parseInt(addguestTBHTF.getText());
        String email = addguestEAddressTF.getText();
        String addressLine = addguestAddressTF.getText();
        String city = addguestCityTF.getText();
        String state = addguestStateTF.getText();
        String country = addguestCountryTF.getText();
        String postalCode = addguestZipcodeTF.getText();



        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(query);

            statement.setString(1,nationalCode);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,number);
            statement.setInt(5,times);
            statement.setString(6,email);
            statement.setString(7,addressLine);
            statement.setString(8,city);
            statement.setString(9,state);
            statement.setString(10,country);
            statement.setString(11,postalCode);


            statement.executeUpdate();

        } catch (Exception exception){
            exception.printStackTrace();
        }

        showGuest();

    }


    //String query = "INSERT INTO guests (national_code,first_name,last_name,contact_number,times_been_here" +
    //                        ",email_address,address_line,city,state,country,postal_code) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";


    @FXML
    private void updateGuest(){
        String query  = "UPDATE guests SET national_code = ?, first_name = ?, last_name = ?, contact_number = ?,"
                + " times_been_here = ?, email_address = ? ,address_line = ? , city = ? , state = ? " +
                ",country = ?, postal_code = ?   WHERE guest_id = " + Integer.parseInt(addguestIDTF.getText());

        String nationalCode = addguestNCTF.getText();
        String firstName = addguestFNameTF.getText();
        String lastName = addguestLNameTF.getText();
        String number = addGuestCNTF.getText();
        int times = Integer.parseInt(addguestTBHTF.getText());
        String email = addguestEAddressTF.getText();
        String addressLine = addguestAddressTF.getText();
        String city = addguestCityTF.getText();
        String state = addguestStateTF.getText();
        String country = addguestCountryTF.getText();
        String postalCode = addguestZipcodeTF.getText();



        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,nationalCode);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,number);
            statement.setInt(5,times);
            statement.setString(6,email);
            statement.setString(7,addressLine);
            statement.setString(8,city);
            statement.setString(9,state);
            statement.setString(10,country);
            statement.setString(11,postalCode);

            statement.executeUpdate();

        } catch (Exception exception){
            exception.printStackTrace();
        }

        showGuest();


    }

    @FXML
    private void deleteGuest(){
        String query = "DELETE FROM guests WHERE guest_id =" + Integer.parseInt(addguestIDTF.getText());
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (Exception exception){
            exception.printStackTrace();
        }

        showGuest();

    }

    @FXML
    private void handleClickedOnGuestTable (){
        Guest guest = guestTable.getSelectionModel().getSelectedItem();
        addguestIDTF.setText(String.valueOf(guest.getGuestID()));
        addguestNCTF.setText(guest.getGuestNC());
        addguestFNameTF.setText(guest.getGuestFName());
        addguestLNameTF.setText(guest.getGuestLName());
        addGuestCNTF.setText(guest.getGuestCN());
        addguestTBHTF.setText(String.valueOf(guest.getGuestTBH()));
        addguestEAddressTF.setText(guest.getGuestEA());
        addguestAddressTF.setText(guest.getGuestALine());
        addguestCityTF.setText(guest.getGuestCity());
        addguestStateTF.setText(guest.getGuestState());
        addguestCountryTF.setText(guest.getGuestCountry());
        addguestZipcodeTF.setText(guest.getGuestZipCode());

    }


//Rooms

    public ObservableList<Room> getRoomList(){
        ObservableList<Room> roomsList = FXCollections.observableArrayList();

        String query = "select room_id,room_number,room_type_room_type_id,hotel_hotel_id" +
                " from room; ";

        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            Room room = null;

            while (resultSet.next()){

                room = new Room (resultSet.getInt("room_id"), resultSet.getInt("room_number"),
                        resultSet.getInt("room_type_room_type_id"),resultSet.getInt("hotel_hotel_id"));
                roomsList.add(room);

            }

        } catch (Exception exception){
            exception.printStackTrace();

        }
        return roomsList;

    }





    public void showRoom(){

        ObservableList<Room> list = getRoomList();

        roomsRoomIDColumn.setCellValueFactory(new PropertyValueFactory<Room,Integer>("roomID"));
        roomsRoomNumberColumn.setCellValueFactory(new PropertyValueFactory<Room,Integer>("roomNumber"));
        roomsRoomTypeColumn.setCellValueFactory(new PropertyValueFactory<Room,Integer>("roomType"));
        roomsHotelIDColumn.setCellValueFactory(new PropertyValueFactory<Room,Integer>("roomHotelID"));




        roomsTable.setItems(list);


    }



    @FXML
    private void insertRoom() {


        String query = "INSERT INTO room (room_number,room_type_room_type_id,hotel_hotel_id) VALUES (?,?,?)";



        int roomNumber = Integer.parseInt(addRoomRNTF.getText());
        int roomType = Integer.parseInt(addRoomRTTF.getText());
        int hotelID = Integer.parseInt(addRoomHIDTF.getText());




        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(query);

            statement.setInt(1,roomNumber);
            statement.setInt(2,roomType);
            statement.setInt(3,hotelID);



            statement.executeUpdate();

        } catch (Exception exception){
            exception.printStackTrace();
        }

        showRoom();

    }





    @FXML
    private void updateRoom(){
        String query  = "UPDATE room SET room_number = ?, room_type_room_type_id = ?, hotel_hotel_id = ?  WHERE room_id = " + Integer.parseInt(addRoomIDTF.getText());


        int roomNumber = Integer.parseInt(addRoomRNTF.getText());
        int roomType = Integer.parseInt(addRoomRTTF.getText());
        int hotelID = Integer.parseInt(addRoomHIDTF.getText());




        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(query);

            statement.setInt(1,roomNumber);
            statement.setInt(2,roomType);
            statement.setInt(3,hotelID);



            statement.executeUpdate();

        } catch (Exception exception){
            exception.printStackTrace();
        }

        showRoom();

    }

    @FXML
    private void deleteRoom(){
        String query = "DELETE FROM room WHERE room_id =" + Integer.parseInt(addRoomIDTF.getText());
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (Exception exception){
            exception.printStackTrace();
        }

        showRoom();

    }

    @FXML
    private void handleClickedOnRoomTable (){
        Room room = roomsTable.getSelectionModel().getSelectedItem();
        addRoomIDTF.setText(String.valueOf(room.getRoomID()));
        addRoomRNTF.setText(String.valueOf(room.getRoomNumber()));
        addRoomRTTF.setText(String.valueOf(room.getRoomType()));
        addRoomHIDTF.setText(String.valueOf(room.getRoomHotelID()));

    }



//profitable guests

    public ObservableList<ProfitableGuest> getProfitableGuestList(){
        ObservableList<ProfitableGuest> profitableGuestsList = FXCollections.observableArrayList();

        String query =
                "SELECT guests_guest_id AS Guest_ID,first_name,last_name, sum(total_payment) AS Total " +
                "FROM bookings right JOIN guests ON bookings.guests_guest_id = guests.guest_id and  booking_date between " +
                        mostPGuestsFromDateDP.getValue().toString().replaceAll("-","") +" and " +
                        mostPGuestsToDateDP.getValue().toString().replaceAll("-","")  +
                " GROUP BY guests_guest_id" +
                " ORDER BY Total desc ;";



        Statement statement;
        ResultSet resultSet;
        Date fdate = Date.valueOf(mostPGuestsFromDateDP.getValue());
        Date todate = Date.valueOf(mostPGuestsToDateDP.getValue());

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ProfitableGuest profitableGuest = null;

            while (resultSet.next()){

                profitableGuest = new ProfitableGuest (
                        resultSet.getInt("Guest_ID"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("Total"),
                        fdate,todate);

                profitableGuestsList.add(profitableGuest);

            }

        } catch (Exception exception){
            exception.printStackTrace();

        }
        return profitableGuestsList;

    }




    @FXML
    public void showProfitableGuest(){

        ObservableList<ProfitableGuest> list = getProfitableGuestList();

        mostPGuestsGuestIDColumn.setCellValueFactory(new PropertyValueFactory<ProfitableGuest,Integer>("ProfitableGuestID"));
        mostPGuestsGFNameColumn.setCellValueFactory(new PropertyValueFactory<ProfitableGuest,String>("ProfitableGuestFName"));
        mostPGuestsGLNameColumn.setCellValueFactory(new PropertyValueFactory<ProfitableGuest,String>("ProfitableGuestLName"));
        mostPGuestsTotalColumn.setCellValueFactory(new PropertyValueFactory<ProfitableGuest,Integer>("ProfitableGuestTotalSpending"));
        mostPGuestsFromDateColumn.setCellValueFactory(new PropertyValueFactory<ProfitableGuest,Date>("ProfitableGuestFromDate"));
        mostPGuestsToDateColumn.setCellValueFactory(new PropertyValueFactory<ProfitableGuest,Date>("ProfitableGuestToDate"));




        mostPGuestsTable.setItems(list);


    }



//most used rooms




    public ObservableList<MostUsedRoom> getMostUsedRoomList(){
        ObservableList<MostUsedRoom> mostUsedRoomsList = FXCollections.observableArrayList();

        String query =
                " SELECT room_room_id,count(room_number) as frequent " +
                        " FROM bookings INNER JOIN room INNER JOIN guests ON room_room_id = room_id and guest_id = guests_guest_id and booking_date between " +
                          mostUsedRoomsFromDateDP.getValue().toString().replaceAll("-","") +
                         " AND "
                        + mostUsedRoomsToDateDP.getValue().toString().replaceAll("-","") +
                        " group by room_number " +
                        " ORDER BY frequent desc ;";



        Statement statement;
        ResultSet resultSet;
        Date fdate = Date.valueOf(mostUsedRoomsFromDateDP.getValue());
        Date todate = Date.valueOf(mostUsedRoomsToDateDP.getValue());

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            MostUsedRoom mostUsedRoom = null;

            while (resultSet.next()){

                mostUsedRoom = new MostUsedRoom (
                        resultSet.getInt("room_room_id"),
                        resultSet.getInt("frequent"),
                        fdate,todate);

                mostUsedRoomsList.add(mostUsedRoom);

            }

        } catch (Exception exception){
            exception.printStackTrace();

        }
        return mostUsedRoomsList;

    }




    @FXML
    public void showMostUsedRoom(){

        ObservableList<MostUsedRoom> list = getMostUsedRoomList();

        mostUsedRoomsRoomIDColumn.setCellValueFactory(new PropertyValueFactory<MostUsedRoom,Integer>("MostUsedRoomID"));
        mostUsedRoomsTimesUsedColumn.setCellValueFactory(new PropertyValueFactory<MostUsedRoom,Integer>("MostUsedTimesUsed"));
        mostUsedRoomsFromDateColumn.setCellValueFactory(new PropertyValueFactory<MostUsedRoom,Date>("MostUsedRoomFromDate"));
        mostUsedRoomsToDateColumn.setCellValueFactory(new PropertyValueFactory<MostUsedRoom,Date>("MostUsedRoomToDate"));




        mostUsedRoomsTable.setItems(list);


    }


    // most used hotels

    public ObservableList<MostUsedHotel> getMostUsedHotelList(){
        ObservableList<MostUsedHotel> mostUsedHotelsList = FXCollections.observableArrayList();

        String query =
                " SELECT bookings.hotel_hotel_id,count(hotel_hotel_id) as frequency " +
                        "FROM bookings INNER JOIN hotel  ON hotel_id = hotel_hotel_id AND booking_date BETWEEN " +
                        mostUsedHotelsFromDateDP.getValue().toString().replaceAll("-","") +
                        " AND " +
                        mostUsedHotelsToDateDP.getValue().toString().replaceAll("-","")
                        + " GROUP BY hotel_hotel_id " +
                        "ORDER BY frequency DESC ; ";



        Statement statement;
        ResultSet resultSet;
        Date fdate = Date.valueOf(mostUsedHotelsFromDateDP.getValue());
        Date todate = Date.valueOf(mostUsedHotelsToDateDP.getValue());

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            MostUsedHotel mostUsedHotel = null;

            while (resultSet.next()){

                mostUsedHotel = new MostUsedHotel (
                        resultSet.getInt("bookings.hotel_hotel_id"),
                        resultSet.getInt("frequency"),
                        fdate,todate);

                mostUsedHotelsList.add(mostUsedHotel);

            }

        } catch (Exception exception){
            exception.printStackTrace();

        }
        return mostUsedHotelsList;

    }




    @FXML
    public void showMostUsedHotel(){

        ObservableList<MostUsedHotel> list = getMostUsedHotelList();

        mostUsedHotelsHotelIDColumn.setCellValueFactory(new PropertyValueFactory<MostUsedHotel,Integer>("MostUsedHotelID"));
        mostUsedHotelsTimesUsedColumn.setCellValueFactory(new PropertyValueFactory<MostUsedHotel,Integer>("MostUsedTimesUsed"));
        mostUsedHotelsFromDateColumn.setCellValueFactory(new PropertyValueFactory<MostUsedHotel,Date>("MostUsedHotelFromDate"));
        mostUsedHotelsToDateColumn.setCellValueFactory(new PropertyValueFactory<MostUsedHotel,Date>("MostUsedHotelToDate"));




        mostUsedHotelsTable.setItems(list);


    }


    // most profitable cities


    public ObservableList<ProfitableCity> getProfitableCity(){
        ObservableList<ProfitableCity> profitableCitiesList = FXCollections.observableArrayList();

        String query =
                " SELECT city as City,count(city) as Frequency " +
                        " FROM bookings INNER JOIN guests  ON guests_guest_id = guest_id and booking_date between " +
                        mostPCityFromDateDP.getValue().toString().replaceAll("-","")
                        + " and " +
                        mostPCityToDateDP.getValue().toString().replaceAll("-","")
                        + " group by City " +
                        " ORDER BY Frequency desc ; ";



        Statement statement;
        ResultSet resultSet;
        Date fdate = Date.valueOf(mostPCityFromDateDP.getValue());
        Date todate = Date.valueOf(mostPCityToDateDP.getValue());

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ProfitableCity profitableCity = null;

            while (resultSet.next()){

                profitableCity = new ProfitableCity (
                        resultSet.getString("City"),
                        resultSet.getInt("Frequency"),
                        fdate,todate);

                profitableCitiesList.add(profitableCity);

            }

        } catch (Exception exception){
            exception.printStackTrace();

        }
        return profitableCitiesList;

    }




    @FXML
    public void showProfitableCities(){

        ObservableList<ProfitableCity> list = getProfitableCity();

        mostPCityNameColumn.setCellValueFactory(new PropertyValueFactory<ProfitableCity,String>("ProfitableCityName"));
        mostPCityTimesColumn.setCellValueFactory(new PropertyValueFactory<ProfitableCity,Integer>("ProfitableCityTimes"));
        mostPCityFromDateColumn.setCellValueFactory(new PropertyValueFactory<ProfitableCity,Date>("ProfitableCityFromDate"));
        mostPCityToDateColumn.setCellValueFactory(new PropertyValueFactory<ProfitableCity,Date>("ProfitableCityToDate"));




        mostPCityTable.setItems(list);


    }


// most used service


    public ObservableList<MostUsedService> getMostUsedService(){
        ObservableList<MostUsedService> mostUsedServicesList = FXCollections.observableArrayList();

        String query =
                " SELECT service_name,COUNT(hotel_services_service_id) AS Times_Used " +
                        " FROM service_used INNER JOIN hotel_services INNER JOIN bookings ON bookings_booking_id = booking_id AND hotel_services_service_id = service_id AND booking_date between  " +
                        mostUsedServicesFromDateDP.getValue().toString().replaceAll("-","")
                        + " and " +
                        mostUsedServicesToDateDP.getValue().toString().replaceAll("-","")

                        + " WHERE booking_id IN " +
                        " (" +
                        "SELECT booking_id AS Bookings_ID " +
                        "FROM room_type INNER JOIN room INNER JOIN bookings ON room_room_id = room_id ON room_type_id = room_type_room_type_id " +
                        "WHERE smoke_friendly = 1 " +
                        ")" +
                        "GROUP BY hotel_services_service_id " +
                        "ORDER BY Times_Used DESC ; ";



        Statement statement;
        ResultSet resultSet;
        Date fdate = Date.valueOf(mostUsedServicesFromDateDP.getValue());
        Date todate = Date.valueOf(mostUsedServicesToDateDP.getValue());

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            MostUsedService mostUsedService = null;

            while (resultSet.next()){

                mostUsedService = new MostUsedService (
                        resultSet.getString("service_name"),
                        resultSet.getInt("Times_Used"),
                        fdate,todate);

                mostUsedServicesList.add(mostUsedService);

            }

        } catch (Exception exception){
            exception.printStackTrace();

        }
        return mostUsedServicesList;

    }




    @FXML
    public void showMostUsedSevices(){

        ObservableList<MostUsedService> list = getMostUsedService();

        mostUsedServicesSNameColumn.setCellValueFactory(new PropertyValueFactory<MostUsedService,String>("MostUsedServiceName"));
        mostUsedServicesTimesColumn.setCellValueFactory(new PropertyValueFactory<MostUsedService,Integer>("MostUsedServiceTimes"));
        mostUsedServicesFromDateColumn.setCellValueFactory(new PropertyValueFactory<MostUsedService,Date>("MostUsedServiceFromDate"));
        mostUsedServicesToDateColumn.setCellValueFactory(new PropertyValueFactory<MostUsedService,Date>("MostUsedServiceToDate"));




        mostUsedServicesTable.setItems(list);


    }



// not used hotel

    public ObservableList<NotUsedHotel> getNoteUsedHotel(){
        ObservableList<NotUsedHotel> notUsedHotelsList = FXCollections.observableArrayList();

        String query =
                " select distinct guest_id,hotel.city,hotel_id from hotel right join ( select * from ( select guest_id,city,hotel_hotel_id as fhotel_id " +
                        " from bookings right join ( " +
                        " select guest_id,city,max(tbic) as BITCity from ( select guests_guest_id as guest_id,city,count(city) as tbic " +
                        " from hotel right join ( " +
                        " select guests_guest_id,hotel_hotel_id from bookings " +
                        " having guests_guest_id = " + Integer.parseInt(unusedHotelsGuestIDTF.getText()) + " ) as A1 on hotel_id = hotel_hotel_id group by city) as A2 ) as A3 " +
                        " on guests_guest_id = guest_id ) As A8 ) AS A4 on hotel.city = A4.city and hotel.hotel_id not in " +
                        " ( select fhotel_id from (select guest_id,city,hotel_hotel_id as fhotel_id " +
                        " from bookings right join ( select guest_id,city,max(tbic) as BITCity " +
                        " from ( select guests_guest_id as guest_id,city,count(city) as tbic " +
                        " from hotel right join ( " +
                        " select guests_guest_id,hotel_hotel_id from bookings " +
                        " having guests_guest_id = "  + Integer.parseInt(unusedHotelsGuestIDTF.getText()) +  "  ) as A1 on hotel_id = hotel_hotel_id " +
                        " group by city ) as A2 ) as A3 " +
                        " on guests_guest_id = guest_id ) AS A9 ) ; " ;



        Statement statement;
        ResultSet resultSet;
      //  Date fdate = Date.valueOf(unusedHotelsFromDateDP.getValue());
     //   Date todate = Date.valueOf(unusedHotelsToDateDP.getValue());

        Date fdate = Date.valueOf("2000-01-01");
        Date todate = Date.valueOf("2030-01-01");

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            NotUsedHotel notUsedHotel = null;

            while (resultSet.next()){

                notUsedHotel = new NotUsedHotel (
                        resultSet.getInt("guest_id"),
                        resultSet.getString("hotel.city"),
                        resultSet.getInt("hotel_id"),
                        fdate,todate);

                notUsedHotelsList.add(notUsedHotel);

            }

        } catch (Exception exception){
            exception.printStackTrace();

        }
        return notUsedHotelsList;

    }




    @FXML
    public void showNotUsedHotel(){

        ObservableList<NotUsedHotel> list = getNoteUsedHotel();

        unusedHotelsGuestIDColumn.setCellValueFactory(new PropertyValueFactory<NotUsedHotel,Integer>("NotUsedHotelGuestID"));
        unusedHotelsCityNameColumn.setCellValueFactory(new PropertyValueFactory<NotUsedHotel,String>("NotUsedHotelCityName"));
        unusedHotelsHotelIDColumn.setCellValueFactory(new PropertyValueFactory<NotUsedHotel,Integer>("NotUsedHotelID"));
        unusedHotelsFromDateColumn.setCellValueFactory(new PropertyValueFactory<NotUsedHotel,Date>("NotUsedHotelFromDate"));
        unusedHotelsToDateColumn.setCellValueFactory(new PropertyValueFactory<NotUsedHotel,Date>("NotUsedHotelToDate"));




        unusedHotelsTable.setItems(list);


    }





















}
