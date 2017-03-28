package filepriochainee;

/**
 *
 * @author Milev
 */
public class FilePrioChainee<T extends ITachePrio> implements IFilePrio<T> {

    private Maillon<T> elements;
    private int taille;

    /**
     * Enfile l'element (non null) dans cette file de priorite.
     *
     * @param element l'element a enfiler dans cette file de priorite.
     * @throws NullPointerException si l'element donne en parametre est null.
     */
    @Override
    public void enfiler(T element) {
        Maillon tmp;
        int priorite = element.getPriorite();

        while (elements != null) {
            if (elements.getInfo().getPriorite() <= priorite) {

                element = (T) elements;

            } else {

                elements.setSuivant((Maillon<T>) element);

            }

            elements.getSuivant();

        }

    }

    /**
     * Defile l'element le plus prioritaire (premier arrivee de la plus grande
     * priorite) de cette file de priorite.
     *
     * @return l'element defile.
     * @throws FileVideException si cette file de priorite est vide avant
     * l'appel de cette methode.
     */
    @Override
    public T defiler() throws FileVideException {
        Maillon tmp;
        tmp = elements;
        if (tmp == null) {

            throw new FileVideException();

        }
        elements = elements.getSuivant();
        return (T) tmp;
    }

    /**
     * Defile l'element le plus prioritaire de la priorite donnee en parametre.
     * Si aucun element de la priorite donnee n'existe dans cette file de
     * priorite, la methode retourne null et cette file de priorite n'est pas
     * modifiee.
     */
    @Override
    public T defiler(int priorite) throws FileVideException {
        Maillon tmp;
        tmp = elements;
        Maillon defiler = null;

        while (tmp != null) {

            if (tmp.getInfo().getPriorite() == priorite) {

                defiler = tmp;
                elements = elements.getSuivant();
                tmp = null;

            }
            if (tmp != null) {

                tmp = tmp.getSuivant();

            }

        }
        return (T) defiler;
    }

    /**
     * Defile tous les elements de la priorite donnee. Si aucun element de cette
     * priorite n'existe dans cette file de priorite, celle-ci n'est pas
     * modifiee. La methode retourne une file de priorite contenant tous les
     * elements defiles, dans le meme ordre que lorsqu'ils se trouvaient dans
     * cette file de priorite. Si aucun element n'est defile, la file retournee
     * est vide.
     *
     * @param priorite
     * @return
     * @throws FileVideException
     */
    @Override
    public IFilePrio<T> defilerTous(int priorite) throws FileVideException {
        Maillon reponse = null;
        Maillon tmp;
        tmp = elements;

        while (tmp != null) {

            if (tmp.getInfo().getPriorite() == priorite) {
                if (reponse == null) {
                    reponse = tmp;
                } else {

                    reponse.setSuivant(tmp);

                }

            }

            tmp = tmp.getSuivant();

        }
        return (IFilePrio<T>) reponse;

    }

    /**
     * Verifie si cette file de priorite contient au moins un element ayant la
     * priorite donnee en parametre.
     *
     * @param priorite la priorite dont on veut verifier l'existence dans cette
     * file de priorite.
     * @return true si au moins un element ayant la priorite donnee en parametre
     * existe dans cette file de priorite, false sinon.
     */
    @Override
    public boolean prioriteExiste(int priorite) {
        int prioCompare;
        Maillon tmp;
        boolean existe = false;
        tmp = elements;

        while (tmp != null) {
            prioCompare = tmp.getInfo().getPriorite();
            if (priorite == prioCompare) {

                existe = true;

            }

            tmp = tmp.getSuivant();

        }
        return existe;
    }

    /**
     * Verifie si cette file de priorite contient des elements ou non.
     *
     * @return true si cette file de priorite ne contient aucun element, false
     * sinon.
     */
    @Override
    public boolean estVide() {
        boolean estVide = true;
        if (elements != null) {

            estVide = false;

        }
        return estVide;
    }

    /**
     * Permet d'obtenir le nombre d'elements contenus dans cette file de
     * priorite.
     *
     * @return le nombre d'elements dans cette file de priorite.
     */
    @Override
    public int taille() {
        taille = 0;
        while (elements != null) {

            ++taille;

        }
        return taille;
    }

    /**
     * Permet d'obtenir le nombre d'elements ayant la priorite donnee en
     * parametre qui sont contenus dans cette file de priorite.
     *
     * @param priorite la priorite des elements dont on veut le nombre.
     * @return le nombre d'elements ayant la priorite donnee en parametre qui
     * sont contenus dans cette file de priorite.
     */
    @Override
    public int taille(int priorite) {
        taille = 0;
        Maillon tmp;
        int prioCompare;
        tmp = elements;

        while (tmp != null) {
            prioCompare = tmp.getInfo().getPriorite();
            if (priorite == prioCompare) {

                ++taille;

            }

            tmp = tmp.getSuivant();

        }
        return taille;
    }

    /**
     * Permet de consulter l'element en tete de cette file de priorite, sans
     * modifier celle-ci. L'element en tete de file est toujours l'element le
     * plus ancien parmis ceux ayant la priorite la plus forte.
     *
     * @return l'element en tete de cette file de priorite.
     * @throws FileVideException si cette file de priorite est vide avant
     * l'appel de cette methode.
     */
    @Override
    public T premier() throws FileVideException {
        Maillon tmp;
        tmp = elements;
        if (tmp == null) {

            throw new FileVideException();

        }

        return (T) tmp;
    }

    /**
     * Permet de consulter l'element le plus prioritaire de la priorite donnee
     * en parametre, sans modifier cette file de priorite. Si aucun element de
     * la priorite donnee existe dans cette file de priorite, la methode
     * retourne null.
     *
     * @param priorite la priorite de l'element le plus prioritaire que l'on
     * veut consulter.
     * @return l'element le plus prioritaire de la priorite donnee en parametre.
     * @throws FileVideException si cette file de priorite est vide avant
     * l'appel de cette methode.
     */
    @Override
    public T premier(int priorite) throws FileVideException {
        Maillon tmp;
        int prioCompare;
        tmp = elements;
        Maillon premier = null;

        while (tmp != null) {

            if (priorite == tmp.getInfo().getPriorite()) {

                premier = tmp;
                tmp = null;

            }
            if (tmp != null) {

                tmp = tmp.getSuivant();

            }

        }

        return (T) premier;
    }

    /**
     * Retire tous les elements de cette file de priorite. Apres l'appel de
     * cette methode, l'appel de la methode estVide() retourne true.
     */
    @Override
    public void vider() {
        while (elements != null) {

            elements = elements.getSuivant();

        }
    }

    /**
     * Retourne une file de priorite contenant tous les elements ayant la
     * priorite donnee en parametre se trouvant dans cette file de priorite. Les
     * elements dans la file de priorite a retourner doivent conserver l'ordre
     * dans lequel ils apparaissent dans cette file de priorite. Apres l'appel
     * de cette methode, cette file de priorite ne doit pas avoir ete modifiee.
     * De plus, si aucun element ayant la priorite donnee ne se trouve dans
     * cette file de priorite, la methode retourne une file de priorite vide.
    *
     */
    @Override
    public IFilePrio<T> sousFilePrio(int priorite) {
        Maillon file = null;
        Maillon tmp;
        tmp = elements;

        while (tmp != null) {

            if (tmp.getInfo().getPriorite() == priorite) {

                file = tmp;

            }
            tmp = tmp.getSuivant();

        }
        return (IFilePrio<T>) file;

    }

    /**
     * Teste si cette file de priorite contient au moins un element identique a
     * celui donne en parametre. Un element e1 est identique a un element e2 si
     * e1.equals(e2) retourne true.
     *
     * @param elem l'element dont on teste l'existence.
     * @return true s'il existe au moins un element dans cette file de priorite
     * qui est identique a celui donne en parametre, false sinon.
     */
    @Override
    public boolean contient(T elem) {
        boolean contient = false;
        Maillon tmp;
        tmp = elements;

        while (tmp != null) {

            if (tmp.equals(elem)) {

                contient = true;

            }
            tmp.getSuivant();

        }
        return contient;
    }

    @Override
    public void normaliser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminerDoublons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Permet d'obtenir la priorite la plus grande parmi les priorites de tous
     * les elements de cette file de priorite.
     *
     * @return la priorite maximum dans cette file de priorite.
     * @throws FileVideException si cette file de priorite est vide avant
     * l'appel de cette methode.
     */
    @Override
    public int prioriteMax() throws FileVideException {
        Maillon tmp;
        int max = 0;
        int prioCompare;
        tmp = elements;
        prioCompare = tmp.getInfo().getPriorite();

        while (tmp != null) {

            if (prioCompare <= tmp.getSuivant().getInfo().getPriorite()) {

                max = tmp.getSuivant().getInfo().getPriorite();

            }

            tmp = tmp.getSuivant();

        }
        return max;
    }

    /**
     * Permet d'obtenir la priorite la plus petite parmi les priorites de tous
     * les elements de cette file de priorite.
     *
     * @return la priorite minimum dans cette file de priorite.
     * @throws FileVideException si cette file de priorite est vide avant
     * l'appel de cette methode.
     */
    @Override
    public int prioriteMin() throws FileVideException {
        Maillon tmp;
        int min = 0;
        int prioCompare;
        tmp = elements;
        prioCompare = tmp.getInfo().getPriorite();

        while (tmp != null) {

            if (prioCompare >= tmp.getSuivant().getInfo().getPriorite()) {

                min = tmp.getSuivant().getInfo().getPriorite();

            }

            tmp = tmp.getSuivant();

        }
        return min;
    }

    /**
     * Retourne une copie de cette file de priorite.
     *
     * @return une copie de cette file de priorite.
     */
    @Override
    public IFilePrio<T> copie() {
        Maillon reponse = null;
        Maillon dernier;
        if (elements != null) {
            reponse = new Maillon(elements.getInfo());
            dernier = reponse;
            elements = elements.getSuivant();
            while (elements != null) {

                dernier.setSuivant(new Maillon(elements.getInfo()));
                dernier = dernier.getSuivant();
                elements = elements.getSuivant();

            }

        }
        return (IFilePrio<T>) reponse;
    }

    @Override
    public String toString() {
        String s = "tete [ ";
        Maillon<T> tmp = elements;

        if (tmp == null) {
            s = s + " ] fin";
        } else {
            while (tmp != null) {
                s = s + tmp.getInfo() + ", ";
                tmp = tmp.getSuivant();
            }
            s = s.substring(0, s.length() - 2) + " ] fin";
        }
        return s;
    }

}
