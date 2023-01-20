import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class View implements Initializable {

    public TextArea showResult;


    final int INITIAL_VALUE = 1;

    public Spinner<Integer> firstNumber;
    SpinnerValueFactory<Integer> firstRandom = new SpinnerValueFactory.IntegerSpinnerValueFactory(3,10,INITIAL_VALUE);

    public Spinner<Integer> secondNumber;
    SpinnerValueFactory <Integer> secondRandom = new SpinnerValueFactory.IntegerSpinnerValueFactory(3,10,INITIAL_VALUE);


    int [] newArr = new int[20];

    public void handleGenerateNumbers(ActionEvent actionEvent) {



        int firstNumberValue = firstNumber.getValue();
        int secondNumberValue = secondNumber.getValue();

        Random rd = new Random();


        showResult.clear();
        showResult.appendText("[N;M] შუალედში 20 შემთხვევითი რიცხვია : ");
        for(int i = 0 ; i < 20; i++){
            int randomNumbers = rd.nextInt(firstNumberValue,secondNumberValue);
            newArr[i] = randomNumbers;
            showResult.appendText(newArr[i] + " ");
        }
        showResult.appendText("\n");


        // xshirad gameorebadi ricxvis logika

        int maxCount = 0;
        int mostRepeated = 0;

        for(int i = 0 ; i < newArr.length; i++){
            int count = 0;

            for(int j = 0 ; j < newArr.length; j++){
                if(newArr[i] == newArr[j]){
                    count++;
                }
            }

            if(count > maxCount){
                maxCount = count;
                mostRepeated = newArr[i];
            }
        }

        showResult.appendText("მოცემულ ლისტში ყველაზე ხშირად გამორებადი რიცხვია : " +mostRepeated);

        // xshirad gameorebadi ricxvis logika



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNumber.setValueFactory(firstRandom);
        secondNumber.setValueFactory(secondRandom);
    }

    public void handleDeleteEven(ActionEvent actionEvent) {

    }
}
