package org.example;

public class ParsingString {
    private String lastName, firstName, middleName;
    private String dataOfBirth;
    private String phone;
    private String gender;


    public String toDo(String str){
        String[] line = str.split(" ");

        String ans = null;
        try{
            checkName(line[0], line[1], line[2]);
            checkDataOfBirth(line[3]);
            checkPhone(line[4]);
            checkGender(line[5]);
            System.out.println("Все данные введены корректно");
            String[] value = {"<", lastName, ">",
                    "<", firstName, ">",
                    "<", middleName, ">",
                    "<", dataOfBirth, ">",
                    "<+7", phone, ">",
                    "<", gender, ">"};
            ans = String.join("", value);
        } catch (IncorrectDataException e){
            System.out.println(e.getMessage());
        }

        return ans;
    }
    private void checkName(String nameLast, String nameFirst, String nameMiddle){
        checkSymbol(nameLast, "str");
        checkSymbol(nameFirst, "str");
        checkSymbol(nameMiddle, "str");

        lastName = nameLast;
        firstName = nameFirst;
        middleName = nameMiddle;
    }

    private void checkDataOfBirth(String data){
        String[] line = data.split("\\.");
        checkSymbol(line[0], "num");
        checkSymbol(line[1], "num");
        checkSymbol(line[2], "num");

        if(line[0].length() != 2 || line[1].length() != 2 || line[2].length() != 4){
            throw new IncorrectDataException("Некорректная дата рождения");
        } else {
            dataOfBirth = data;
        }
    }
    private void checkPhone(String newPhone){
        checkSymbol(newPhone, "num");
        if(newPhone.length() != 10){
            throw new IncorrectDataException("Некорректный номер телефона");
        } else{
            phone = newPhone;
        }

    }
    private void checkGender(String g){
        if(g.equals("f") || g.equals("m")){
            gender = g;

        }else {
            throw new IncorrectDataException("Проблемы с вашим гендером(");
        }
    }

    private boolean checkSymbol(String data, String mode) {
        char[] chars = data.toCharArray();
        switch (mode){
            case("str"):
                for (char c : chars) {
                    if(!Character.isLetter(c)) {
                        throw new IncorrectDataException("Некорректное имя");
                    }
                }
                return true;
            case ("num"):
                for (char c : chars) {
                    if(!Character.isDigit(c)) {
                        throw new IncorrectDataException("Некорректные числовые данные");
                    }
                }
                return true;
        }
        return false;
    }

    public String getLastName() {
        return lastName;
    }
}
class IncorrectDataException extends RuntimeException{
    public IncorrectDataException(String message){
        super(message);
    }
}
