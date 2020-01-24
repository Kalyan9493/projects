package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private Label loginlabel;

	@FXML
	private TextField loginempid;
	@FXML
	private TextField loginpassword;
	
	@FXML
	private AnchorPane rootpane;
	@FXML
	private Label registerlabel;
	@FXML
	private TextField regempid;
	@FXML
	private TextField regpassword;
	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private TextField emailid;
	@FXML
	private TextField mobileno;
	
	
public void login(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
		
		String uname=loginempid.getText();
		String pass=loginpassword.getText();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/chatapplication","collectionadmin","collectionadmin");
		PreparedStatement ps=con.prepareStatement("select userid,password from users where userid=? and password=?");
		ps.setString(1, uname);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			
		/*	Stage  primaryStage=new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("/application/Chat.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		*/
			
			AnchorPane root=FXMLLoader.load(getClass().getResource("/application/Chat.fxml"));
			rootpane.getChildren().setAll(root);
						
			
		
		}
		else {
			loginlabel.setText("Enter Correct Credentials..");
		}
	
	}
	public void register(ActionEvent event) throws IOException {
	/*	Stage  primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("/application/Register.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	*/
		AnchorPane root=FXMLLoader.load(getClass().getResource("/application/Register.fxml"));
		rootpane.getChildren().setAll(root);
		
	}
	public void registerdb(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		
		long empid=Long.parseLong(regempid.getText());
		String pass=regpassword.getText();
		String fname=firstname.getText();
		String lname=lastname.getText();
		String email=emailid.getText();
		long mobile=Long.parseLong(mobileno.getText());
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/chatapplication","collectionadmin","collectionadmin");
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		Statement st=con.createStatement();
		String sql="insert into users values('"+empid+"','"+pass+"','"+fname+"','"+lname+"','"+sqlDate+"','"+email+"','"+mobile+"');";
		st.execute(sql);
		registerlabel.setText("Details Saved");
		
		AnchorPane root=FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
		rootpane.getChildren().setAll(root);
		
		
	}

}
