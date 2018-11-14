package ba.unsa.etf.rpr.tutorijal05;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

        public Label result;
        private long number1 = 0;
        private String operator = " ";
        private boolean start = true;
        private Model model = new Model();
        private SimpleStringProperty labela;

        public String getLabela(){
            return labela.get();
        }

        public SimpleStringProperty labelaProperty(){
            return labela;
        }

        @FXML
        public void processNumbers(ActionEvent event){
                if(start){
                        result.setText("");
                        start = false;
                }
                String value = ((Button)event.getSource()).getText();
                result.setText(result.getText()+value);
        }
        @FXML
        public void processOperator(ActionEvent event){
                String value = ((Button)event.getSource()).getText();
                if(!value.equals("=")){
                    if(!operator.isEmpty()) return;
                    operator = value;
                    number1 = Long.parseLong(getLabela());
                    result.setText("");
                } else{
                        if(operator.isEmpty()) return;
                        long number2 = Long.parseLong(getLabela());
                        float output = model.calculate(number2, number2, value);
                        result.setText(String.valueOf(output));
                        operator = "";
                        start = true;
                }
        }
}
