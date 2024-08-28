package daily.challenge.graph;

public class DisJointSet {
    private int[] parent;
    private int[] size;

    DisJointSet(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i]=i;
            size[i]=1;
        }
    }

    int findUP(int u) {
        if (parent[u] == u) return u;
        return findUP(parent[u]);
    }

    void unionBySize(int u, int v) {
        int u_up = findUP(u);
        int v_up = findUP(v);
        if (u_up == v_up) return;
        if (size[u_up] > size[v_up]) {
            parent[v_up] = u_up;
            size[u_up] += v_up;
        }
        else {
            parent[u_up] = v_up;
            size[v_up] += u_up;
        }
    }
}

class Driver {
    public static void main(String[] args) {
        DisJointSet ds = new DisJointSet(7);
        ds.unionBySize(1,7);
        ds.unionBySize(2,3);
        ds.unionBySize(4,6);
        System.out.println("2 and 7 are connected");
        System.out.println(ds.findUP(2) == ds.findUP(7));
        System.out.println("2 and 7 are connected");
        ds.unionBySize(1,3);
        System.out.println(ds.findUP(2) == ds.findUP(7));

    }
}


