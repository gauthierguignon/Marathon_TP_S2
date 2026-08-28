package tp07;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import tdOO.td01.PhoneNumber;

public class BidirectionalPhoneBook {
    
    Map<String, ProPhoneNumber> name2num;
    Map<String, String> num2name;
    
    public BidirectionalPhoneBook() {
        this.name2num = new HashMap<>();
        this.num2name = new HashMap<>();
    }

    public int getNbEntries() {
        return name2num.size();
    }

    public boolean alreadyRegistered(String s) {
        for(Map.Entry<String, ProPhoneNumber> entry : name2num.entrySet()){
            if(s.equalsIgnoreCase(entry.getKey())) return true;
        }
        for(Map.Entry<String, String> entry : num2name.entrySet()){
            if(s.equalsIgnoreCase(entry.getKey())) return true;
        }
        return false;
    }

    public boolean add(String name, UniversityDepartment dept, String fourDigits) {
        if(alreadyRegistered(""+dept.getDiallingCode()+fourDigits)) return false;
        if(alreadyRegistered(name)) return false;
        this.name2num.put(name, new ProPhoneNumber(fourDigits, dept));
        this.num2name.put(""+dept.getDiallingCode()+fourDigits, name);
        return true;
    }

    public ProPhoneNumber getProPhoneNumberFromName(String name) {
        return this.name2num.get(name);
    }

    public String getNameFromFiveDigits(String fiveDigits) {
        return this.num2name.get(fiveDigits);
    }

    public String listing(UniversityDepartment dept) {
        StringBuilder sb = new StringBuilder();
        sb.append(dept.getLabelLong());
        sb.append(System.getProperty("line.separator"));
        for(Map.Entry<String, String> entry : num2name.entrySet()) {
            if(entry.getKey().charAt(0)-'0' == dept.getDiallingCode()) {
                sb.append(entry.getValue()+":"+entry.getKey()+'('+dept.getLabelShort()+')');
                sb.append(System.getProperty("line.separator"));
            }
        }
        return sb.toString();
    }

    public String listing() {
        // Chaque dept à son ArrayList de numéros
        EnumMap<UniversityDepartment, ArrayList<String>> map = new EnumMap<>(UniversityDepartment.class);

        // Tableau de tous les départements Universitaires
        UniversityDepartment[] tabDepartments = UniversityDepartment.values();

        // On crée une paire clé/valeur pour chaque département
        for(UniversityDepartment ud : tabDepartments) {
                map.put(ud, new ArrayList<>());
        }

        // On parcourt num2name
        for(Map.Entry<String, String> entry : num2name.entrySet()) {
            // On détermine à quel dept le num appartient
            UniversityDepartment enCours = tabDepartments [entry.getKey().charAt(0) -'0' -1];
            // On place le numéro dans son ArrayList
            map.get(enCours).add(entry.getValue()+":"+entry.getKey()+'('+enCours.getLabelShort()+')');
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<UniversityDepartment, ArrayList<String>> entry : map.entrySet()) {
            sb.append("" + entry.getKey().getLabelLong() + "\n");
            for(String s : entry.getValue()) {
                sb.append(s+"\n");
            }
        }
        return sb.toString();
    }

}
