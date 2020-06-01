
// Facebook
public class NumberToWords {

  public static void main(String []args){
    System.out.println("Hello World");

    HelloWorld obj = new HelloWorld();
    int num = 438237900;
    String words = obj.numToWords(num);
    System.out.println(num);
    System.out.println(words);
  }

  private String numToWords(int num) {
    StringBuilder words = new StringBuilder();
    int multiplier = 1;

    while (num > 0) {
      int chunk = num % 1000;
      String textChunk = convertChunk(chunk);

      if (multiplier == 1) {
        words.insert(0, textChunk);
      }

      if (multiplier == 1000) {
        words.insert(0, textChunk + "thousands ");
      }

      if (multiplier == 1000000) {
        words.insert(0, textChunk + "millions ");
      }

      multiplier *= 1000;
      num /= 1000;
    }

    return words.toString();
  }

  String[] ones = new String[]{"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine "};

  String[] tensSp = new String[]{"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ", "eleven  ", "twlve ", "thirteen ", "fourteen ", "fiveteen ", "sixteen ", "seventeen ", "eightteen ", "nineteen "};

  String[] tens = new String[]{"", "", "twenty ", "thirty ", "fourty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninty "};

  // in 100s
  private String convertChunk(int num) {
    StringBuilder words = new StringBuilder();

    int num100 = num / 100;
    if (num100 > 0) {
      words.append(ones[num100] + "hundreds ");
    }

    int mod = num % 100;
    if (mod > 19) {
      words.append(tens[mod / 10] + ones[mod % 10]);
    } else {
      words.append(tensSp[mod]);
    }

    return words.toString();
  }
}

/*

1. chunks of 100
2. convert chunk to hundres text
3. arrays

*/