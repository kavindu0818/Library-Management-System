import com.jfoenix.controls.JFXTextArea;
import javafx.scene.control.Label;
import org.example.Controller.UserLogin.UserLogInSecoundFormController;
import org.example.bo.BookBo;
import org.example.bo.BookHandOverBo;
import org.example.bo.BranchBo;
import org.example.bo.Custome.BoFactory;
import org.example.bo.UserBo;

public class UserDashBoardMainFormController {
    public Label lblBookS;
    public Label lablUsers;
    public Label lblBranches;
    public Label lblBooking;
    public Label lblAdmin;
    public JFXTextArea txtNotice;

    BookBo bookBoimpl = (BookBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.BOOK);
    BranchBo branchBoimpl = (BranchBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.BRANCH);
    BookHandOverBo bookHandOverimpl = (BookHandOverBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.BOOKHANDOVER);
    UserBo userBoimpl = (UserBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.USER);
    UserLogInSecoundFormController userLogInSecoundFormController = new UserLogInSecoundFormController();

    public void initialize(){
        setBooks();
        setBarnch();
        setUser();
        setBookin();
        lblAdminSet();
    }

    private void lblAdminSet() {
        lblAdmin.setText(userLogInSecoundFormController.us);
    }

    public void setBooks(){
        int value  = bookBoimpl.setValueBook();
        lblBookS.setText(String.valueOf(value));
    }

    public void setBarnch(){
        int value  = branchBoimpl.getBarnchCount();
        lblBranches.setText(String.valueOf(value));
    }
    public void setUser(){
        int value  = userBoimpl.getUserCount();
        lablUsers.setText(String.valueOf(value));
    }
    public void setBookin(){
        int value  = bookHandOverimpl.getBookingCount();
        lblBooking.setText(String.valueOf(value));
    }
}
