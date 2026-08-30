package tp08_supp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BreedingGround {
    
    private HashSet<Participant> applicants = new HashSet<>();

    public HashSet<Participant> getApplicants() {
        return applicants;
    }

    boolean registration(Participant p) {
        return this.applicants.add(p);
    }

    public List<Participant> loners() {
        List<Participant> loners = new ArrayList<>();
        for(Participant p : this.applicants) {
            if(p.getPartner() == null) loners.add(p);
        }
        return loners;
    }

    public List<Participant> lonersCleansing() {
        List<Participant> loners = this.loners();
        this.applicants.removeAll(loners);
        return loners;
    }

    public void forcedMatching() {
        List<Participant> loners = this.loners();
        int end = loners.size()%2 == 0 ? loners().size() : loners.size() -1;
        for(int i = 0; i < end ; i = i + 2) {
            loners.get(i).matchWith(loners.get(i+1));
            loners.get(i+1).matchWith(loners.get(i));
        }
    }

    public List<Participant> cheaters(BreedingGround anotherBreedingGround) {
        List<Participant> cheaters = new ArrayList<>();
        for(Participant p : this.applicants) {
            for(Participant q : anotherBreedingGround.applicants) {
                if(p.equals(q)) cheaters.add(p);
            }
        }
        return cheaters;
    }

    public void isolateCheater(Participant cheater) {
        Participant p = cheater.getPartner();
        p.breakOff();
        cheater.breakOff();
    }

    // public void cheatersCleansing(BreedingGround anotherBreedingGround) {
    //     List<Participant> cheaters = this.cheaters(anotherBreedingGround);
    //     for(Participant p : cheaters) {
    //         this.isolateCheater(p);
    //     }
    // }

    public void cheatersCleansing(BreedingGround anotherBreedingGround) {
        List<Participant> cheaters = this.cheaters(anotherBreedingGround);
        this.applicants.removeAll(cheaters);
    }

    public boolean possibleMerging(BreedingGround anotherBreedingGround) {
        return this.cheaters(anotherBreedingGround).isEmpty();
    }

    public void merging(BreedingGround anotherBreedingGround) {
        this.applicants.addAll(anotherBreedingGround.applicants);
    }

    public void securedMerging(BreedingGround anotherBreedingGround) {
        if(this.possibleMerging(anotherBreedingGround)) {
            this.merging(anotherBreedingGround);
        } else {
            this.cheatersCleansing(anotherBreedingGround);
            this.merging(anotherBreedingGround);
        }
    }

    public void clear() {
        this.applicants.clear();
    }

}
