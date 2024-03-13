import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Tm.BooksTm;
import org.example.bo.impl.BookBoimpl;
import org.example.dto.BookDto;

import java.util.List;

public class ViewBookDetailsUserController {
    public TableView tblBookDDetails;
    public TableColumn colBookId;
    public TableColumn colBookTitle;
    public TableColumn colBookAuthor;
    public TableColumn colBookCatougery;
    public TableColumn colBookStatus;
    public JFXComboBox cmbBookCatogery;
    public JFXTextField txtBookName;

    BookBoimpl bookBoimpl = new BookBoimpl();

    ObservableList<BooksTm> oblist = FXCollections.observableArrayList();
    public void initialize(){
        loadAllBooks();
        setCellValueFactory();
        searchTable();
        searchTable2();
        setValueCmb();
    }

    private void setValueCmb() {
        //ComboBox<String> comboBox = new ComboBox<>();

        ObservableList<String> catogery = FXCollections.observableArrayList("Kids","Education");

        cmbBookCatogery.setItems(catogery);
    }

    public void searchTable(){
            FilteredList<BooksTm> filteredData = new FilteredList<>(oblist, b -> true);

            txtBookName.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(booksTm -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();
                    String bookId = String.valueOf(booksTm.getId());
                    String title = booksTm.getTitle().toLowerCase();
                    String genre = booksTm.getAuthor().toLowerCase();

                    return bookId.contains(lowerCaseFilter) || title.contains(lowerCaseFilter) || genre.contains(lowerCaseFilter);
                });
            });

            SortedList<BooksTm> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tblBookDDetails.comparatorProperty());
            tblBookDDetails.setItems(sortedData);

    }

    public void searchTable2() {
        FilteredList<BooksTm> filteredData = new FilteredList<>(oblist, b -> true);

        cmbBookCatogery.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(booksTm -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                String bookId = String.valueOf(booksTm.getId());
                String title = booksTm.getTitle().toLowerCase();
                String genre = booksTm.getAuthor().toLowerCase();

                // Check if the genre filter is not empty and matches the selected genre
                boolean genreMatch = newValue.isEmpty() || genre.contains(newValue.toLowerCase());

                return bookId.contains(lowerCaseFilter) || title.contains(lowerCaseFilter) || genreMatch;
            });
        });

        SortedList<BooksTm> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblBookDDetails.comparatorProperty());
        tblBookDDetails.setItems(sortedData);
    }

    private void setCellValueFactory() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colBookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colBookCatougery.setCellValueFactory(new PropertyValueFactory<>("Category"));
        colBookStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadAllBooks() {



        try {
            List<BookDto> bookDtoList = bookBoimpl.getAllBooks();

            System.out.println("mama"); // Check if "mama" is printed

            if (bookDtoList != null) {
                //  System.out.println("Number of books: " + bookDtoList.size()); // Print the number of books in the list
                for (BookDto bookDto : bookDtoList) {
                    oblist.add(new BooksTm(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getCatougery(), bookDto.getStatus()));
                }

                tblBookDDetails.setItems(oblist);
                // tblbooksView.refresh();
            } else {
                System.out.println("The list of books is null.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace to see if there's an exception
            throw new RuntimeException(e);
        }
    }
}
