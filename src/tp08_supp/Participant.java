package tp08_supp;


public class Participant {

    private String name;
    private Participant partner;
    
    public Participant(String name) {
        this.name = name;
    }

    public Participant getPartner() {
        return partner;
    }    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
            this.name = name;
    }
    
    public void setPartner(Participant partner) {
        this.partner = partner;
    }
    
    public String getPartnerName() {
        return partner.getName();
    }
    
    @Override
    public String toString() {
        return "[" + name + " -> " +
            (partner == null ? "null" : partner.getName()) + "]";
    }

    public boolean isMatched() {
        return !(this.partner == null);
    }

    public boolean isMatchedWith(Participant p) {
        return this.partner == p.partner;
    }

    public boolean matchWith(Participant p) {
        if (this.partner != null) return false;
        this.partner = p;
        p.setPartner(this.partner);
        return true;
    }

    public void breakOff() {
        this.partner = null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Participant other = (Participant) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (partner == null) {
            if (other.partner != null)
                return false;
        } else if (!partner.equals(other.partner))
            return false;
        return true;
    }

/*
Notes de Claude sur HashSet et Equals 

Pourquoi pas partner : c'est un attribut mutable qui change après l'insertion dans le HashSet (via matchWith/breakOff). Si hashCode() en dépend, un participant change de bucket une fois haché — le contrat Java est violé : l'objet devient introuvable avec contains()/remove() même s'il est toujours physiquement dans le set. Exactement ce qui se passe dans ton test : p1.matchWith(p2) est appelé dans @BeforeEach, avant l'enregistrement dans v1/v3 — donc ici ça ne casse rien avec ces tests précis, mais c'est une bombe à retardement dès qu'on apparie/sépare des participants déjà enregistrés.

Pourquoi pas le hashCode() par défaut d'Object : il est basé sur l'identité mémoire (implémentation typique : dérivé de l'adresse de l'objet). Deux Participant représentant la même personne (même nom) mais construits séparément seraient alors traités comme différents, et l'equals() par défaut (==) romprait la sémantique métier attendue — typiquement pour cheaters()/registration(), dont la logique de "même participant" est censée reposer sur l'identité logique (le nom), pas sur la référence objet.

hashCode() détermine dans quel bucket (case interne) l'objet va être rangé — c'est une histoire de performance, pas d'identité stricte. Deux objets différents peuvent parfaitement avoir le même hashCode (collision) et finir dans le même bucket.
À l'intérieur d'un même bucket, c'est equals() qui tranche : est-ce le même élément logique ou un doublon à insérer à côté ?

Donc pour contains(), remove(), ou l'insertion d'un doublon dans un HashSet : Java calcule le hash pour localiser le bucket, puis parcourt les éléments de ce bucket avec equals() pour trouver une correspondance exacte. Les deux méthodes doivent être cohérentes (le contrat classique : a.equals(b) == true implique a.hashCode() == b.hashCode()), sinon le set devient incohérent

*/



    public static void main(String[] args) {
        
        Participant p = new Participant("Gauthier");
        Participant p2 = new Participant("Andréa");
        
        p.setPartner(p2);
        p2.setPartner(p);

        System.out.println(p);

    }
}


