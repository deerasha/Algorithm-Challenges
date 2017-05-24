/*
 * Created on 2007/12/19
 *
 */

public class BacktrackingPermutations {

    public static void generate_permutations(int n) {
        int[] a = new int[n+1];
        backtrack(a, 0, n+1);
    }

    public static void backtrack(int[] a, int k, int n) {
        int[] c = new int[n];
        boolean[] in_perm = new boolean[n];
        int ncandidates;
        
        if (k == n-1) {
            for (int j = 1; j < n; j++){
                System.out.print(a[j]);
            }
            System.out.println();
            
        } else {
            k = k + 1;
            
            for (int i = 1; i < n; i++)
                in_perm[i] = false;
            for (int i = 0; i < k; i++) {
                     in_perm[a[i]] = true;
            }
            ncandidates=0;
            for (int i = 0; i < n; i++){
                if(in_perm[i]==false){
                    c[ncandidates]=i;
                    ncandidates++;
                }
            }
             for (int i = 0; i < ncandidates; i++) {
                a[k] = c[i];
                backtrack(a, k, n);
            }
        }
    }
       
    public static void main(String[] args) {

        String elements = "ABCD";
        int n=elements.length();
        
        generate_permutations(n);
  
    }

}//end class