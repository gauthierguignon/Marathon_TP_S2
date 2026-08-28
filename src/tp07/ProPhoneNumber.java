package tp07;

import java.util.Objects;

import tdOO.td01.PhoneNumber;

public class ProPhoneNumber {
 
    private PhoneNumber numbers;
    private UniversityDepartment dept;

    public ProPhoneNumber(String fourLastDigits, UniversityDepartment dept) {
        int composante = dept.getDiallingCode();
        int twoFrstDigit = Integer.parseInt(fourLastDigits.substring(0, 2));
        int twoLastDigit = Integer.parseInt(fourLastDigits.substring(2, 4));
        this.numbers = new PhoneNumber(33, 3, 20, composante, twoFrstDigit, twoLastDigit);
        this.dept = dept;
    }

    public UniversityDepartment getDepartment() {
        return dept;   
    }

    public String internToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(numbers.standardFormat());   // 02.33.31.78.44
        sb.delete(0, 7);            // 1.78.44
        sb.deleteCharAt(1);             // 178.44
        sb.deleteCharAt(3);             // 17844
        sb.append("("+this.dept.getLabelShort()+")"); //17844 (F3S)
        return sb.toString();
    }

    public String externToString() {
        return numbers.internationalFormat() + " (" + this.dept.getLabelLong() + ")";
    }

    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        ProPhoneNumber other = (ProPhoneNumber) obj;
        if (this.numbers == null) {
            return other.numbers == null;
        }
        return this.numbers.equals(other.numbers);
        }

    public boolean equals(String fourDigits) {
        StringBuilder sb = new StringBuilder();
        sb.append(numbers.standardFormat());   // 02.33.31.78.44
        sb.delete(0, 9);            // 78.44
        sb.deleteCharAt(2);             // 7844
        if(!Objects.equals(fourDigits, sb.toString())) return false;
        return true;
    }

    

}
