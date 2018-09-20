package September;

import java.util.*;

//听说暴力解也能过，我这个后面的case估计超时了

public class jd_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Product> aList = new ArrayList<>(n);
        List<Product> bList = new ArrayList<>(n);
        List<Product> cList = new ArrayList<>(n);
        List<Product> productList = new ArrayList<>(n);
        Set<Product> failSet = new HashSet<>();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            Product pro = new Product(a,b,c);
            aList.add(pro);
            bList.add(pro);
            cList.add(pro);
            productList.add(new Product(a,b,c));
        }
        Collections.sort(aList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.a>o2.a){
                    return -1;
                }
                else if(o1.a<o2.a){
                    return 1;
                }
                else
                    return 0;
            }
        });
        Collections.sort(bList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.b>o2.b){
                    return -1;
                }
                else if(o1.b<o2.b){
                    return 1;
                }
                else
                    return 0;
            }
        });
        Collections.sort(cList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.c>o2.c){
                    return -1;
                }
                else if(o1.c<o2.c){
                    return 1;
                }
                else
                    return 0;
            }
        });
        for(int i=0;i<productList.size();i++){
            Product product = productList.get(i);
            int indexA = getIndexA(product,aList);
            int indexB = getIndexB(product,bList);
            int indexC = getIndexC(product,cList);
            if(indexA == aList.size() || indexB == aList.size() || indexC == aList.size())
                continue;
            List<Product> subAList = aList.subList(indexA,aList.size());
            List<Product> subBList = bList.subList(indexB,bList.size());
            List<Product> subCList = cList.subList(indexC,cList.size());
            subAList.retainAll(subBList);
            subAList.retainAll(subCList);
            for(Product product1 : subAList){
                failSet.add(product1);
            }
            aList.removeAll(subAList);
        }
        System.out.println(failSet.size());

    }
    public static int getIndexA(Product pro,List<Product> list){
        int i=0;
        for(;i<list.size();i++){
            if(pro.a <= list.get(i).a)
                continue;
            else
                return i;
        }
        return i;
    }
    public static int getIndexB(Product pro,List<Product> list){
        int i=0;
        for(;i<list.size();i++){
            if(pro.b <= list.get(i).b)
                continue;
            else
                return i;
        }
        return i;
    }
    public static int getIndexC(Product pro,List<Product> list){
        int i=0;
        for(;i<list.size();i++){
            if(pro.c <= list.get(i).c)
                continue;
            else
                return i;
        }
        return i;
    }
}
class Product{
    public int a;
    public int b;
    public int c;
    public Product(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}