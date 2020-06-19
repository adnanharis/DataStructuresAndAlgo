public class HelloWorld {

    public static void main(String []args){
        int[] sortedArr = new int[] {2, 3, 6, 7, 7, 8, 8, 8, 12};
        int target = 9;
        int firstIndex = findAtleast(sortedArr, target);
        int lastIndex = findAtleast(sortedArr, target + 1) - 1;
        if (lastIndex < firstIndex) {
            firstIndex = -1;
            lastIndex = -1;
        }
        System.out.println("Found: " + firstIndex + " " + lastIndex);
    }
    
    private static int findAtleast(int[] sortedArr, int target) {
        int i = 0, j = sortedArr.length - 1, mid;
        
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (sortedArr[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return j + 1;        
        // j++;
        // return j == sortedArr.length ? -1 : j;
    }
  
}


/*public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        int[] sortedArr = new int[] {2, 3, 6, 7, 7, 8, 8, 8, 12};
        int[] result = getFirstAndLastIndexOf(sortedArr, 8);
        System.out.println("First: " + result[0] + " Last: " + result[1]);
     }
     
     private static int[] getFirstAndLastIndexOf(int[] sortedArr, int search) {
         int res[] = new int[] {-1, -1};
         
         if (sortedArr.length == 0) {
             return res;
         }
         
         int midIndex = search(sortedArr, search);
         if (midIndex < 0) {
             return res;
         }
         
        res[0] = searchFirst(sortedArr, search, midIndex);
        res[1] = searchLast(sortedArr, search, midIndex);
        return res;
     }
     
     private static int search(int[] sortedArr, int searchE) {
         int i = 0, j = sortedArr.length - 1, mid;
         
         while (i <= j) {
             mid = i + (j - i) / 2;
             int midE = sortedArr[mid];
             if (midE == searchE) {
                return mid;
             } else if (midE < searchE) {
                i = mid + 1;
             } else {
                j = mid - 1;
             }
         }
         
         return -1;
     }
     
     private static int searchFirst(int[] sortedArr, int searchE, int midIndex) {
         int i = 0, j = midIndex, mid = j;
         
         if (i == j) {
             return i;
         }
         
         while (i + 1 != j) {
             mid = i + (j - i) / 2;
             if (sortedArr[mid] == searchE) {
                 j = mid;
             } else {
                 i = mid;
             }
         }
         
         return j;
     }
     
    private static int searchLast(int[] sortedArr, int searchE, int midIndex) {
         int i = midIndex, j = sortedArr.length - 1, mid = i;
         
         if (i == j) {
             return i;
         }
         
         while (i + 1 != j) {
             mid = i + (j - i) / 2;
             if (sortedArr[mid] == searchE) {
                 i = mid;
             } else {
                 j = mid;
             }
         }
         
         return i;
     }
}*/
