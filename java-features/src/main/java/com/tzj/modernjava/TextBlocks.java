package com.tzj.modernjava;

public class TextBlocks {
  public static void main(String[] args) {
    String html =
        """
                  <html>
                    <head>
                      <title>Raw strings in Java</title>
                    </head>
                    <body>
                      <p>Hello, world1</p>
                    </body>
                 </html>
                 """;
    System.out.println(html);

    String escape =
        """
                    "Hello, world", said the noob to the geek.
                    """;
    System.out.println(escape);
  }
}
