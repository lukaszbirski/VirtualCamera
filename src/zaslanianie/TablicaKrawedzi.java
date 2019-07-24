/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zaslanianie;

import java.util.ArrayList;
import java.util.Collections;

import Models.Edge2D;

/**
 *
 * @author rafal
 */
public class TablicaKrawedzi {
    //zawiera listy rzutow krawedzi zaczynajacych sie w kazdej linii obrazu

    public ArrayList<ArrayList<Krawedz>> lista;
    //ArrayList<Krawedz> [] tablica;

    public TablicaKrawedzi(ArrayList<Edge2D> krw, int wysokoscEkranu) {
        lista = new ArrayList<ArrayList<Krawedz>>(wysokoscEkranu);

        for (int i = 0 ; i < wysokoscEkranu ; i++) {
            lista.add(new ArrayList<Krawedz>());
        }

        for (Edge2D kr : krw) {
            if (kr.point1.y == kr.point2.y) {
                continue;       //ODRZUCANIE poziomych
            }
            Krawedz k = new Krawedz(kr);
            ArrayList<Krawedz> l = lista.get(k.y_dolnego);
            if (l.isEmpty()) {
             //   l = new ArrayList<Krawedz>();
                l.add(k);
               // lista.set(k.y_dolnego, l);
            }
            else {          //mozna tu zoptymalizowac dla przypadku tylko 2 krawedzi o takim samym y_dolnego
//                boolean dodalem = false;
//                for (int i = 0; i < l.size(); i++) {
//                    if (k.x_dolnego < l.get(i).x_dolnego) {
//                        l.add(i, k);
//                        dodalem = true;
//                        break;
//                    } else if (k.x_dolnego == l.get(i).x_dolnego) {
//                        if (k.c < l.get(i).c) {
//                            l.add(i, k);
//                            dodalem = true;
//                            break;
//                        }
//                    }
//                }
//                if (dodalem == false) {
//                    l.add(k);
//                }
                l.add(k);
                Collections.sort(l);
            }
        }
    }

    public class Krawedz implements Comparable{

        int x_dolnego;
        int y_dolnego;
        int x_gornego;
        int y_gornego;
        float c;
        int nr_wielokata1;
        int nr_wielokata2;
        boolean pionowa;
        Edge2D macierzystaKrawedz2D;

        public Krawedz(Edge2D kr) {
            this.macierzystaKrawedz2D = kr;
            pionowa = false;
            if (kr.point1.y < kr.point2.y) {
                x_dolnego = kr.point1.x;
                y_dolnego = kr.point1.y;
                x_gornego = kr.point2.x;
                y_gornego = kr.point2.y;
                c = (float) ((float) x_gornego - x_dolnego) / (y_gornego - y_dolnego);
                nr_wielokata1 = kr.wallNumber1;
                nr_wielokata2 = kr.wallNumber2;
            } else if (kr.point1.y >= kr.point2.y) {
                x_dolnego = kr.point2.x;
                y_dolnego = kr.point2.y;
                x_gornego = kr.point1.x;
                y_gornego = kr.point1.y;
                c = (float) (x_gornego - x_dolnego) / (y_gornego - y_dolnego);
                nr_wielokata1 = kr.wallNumber1;
                nr_wielokata2 = kr.wallNumber2;
            }
            if (x_dolnego == x_gornego) {
               pionowa = true;
            }

        }

//        @Override
//        public String toString() {
//            return "Krawedz{" + "x_dolnego=" + x_dolnego + ", y_dolnego=" + y_dolnego + ", x_gornego=" + x_gornego + ", y_gornego=" + y_gornego + '}' + "\n";
//        }

        @Override
        public String toString() {
            return "Krawedz{" + "x_dolnego=" + x_dolnego + ", y_dolnego=" + y_dolnego + ", x_gornego=" + x_gornego + ", y_gornego=" + y_gornego + ", c=" + c + '}' + "\n";
        }

        @Override
        public int compareTo(Object o) {
            Krawedz k = (Krawedz) o;
            if (this.x_dolnego < k.x_dolnego) {
                return -1;
            } else if (this.x_dolnego > k.x_dolnego) {
                return 1;
            } else {
                if (this.c < k.c) {
                    return -1;
                } else if (this.c > k.c) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
