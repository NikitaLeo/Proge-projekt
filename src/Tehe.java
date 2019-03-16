import java.util.*;

public class Tehe {
    private int N;
    private List<List<Integer>> tabel;

    public Tehe(List<List<Integer>> tabel) {
        this.tabel = tabel;
        N = tabel.size();
    }

    public int get(int i, int j) {
        return tabel.get(i).get(j);
    }

    public boolean onKommutatiivne() {
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if( get(i,j) != get(j,i) ) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean onAssotsiatiivne() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (get(get(i, j), k) != get(i, get(j, k))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean vasakpoolneDistributiivsus(Tehe teineTehe) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if ( get(i,teineTehe.get(j,k)) != teineTehe.get(get(i,j),get(i,k)) ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
