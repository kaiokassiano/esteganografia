steganomaker 0.3.0, 2016-04-16
-
**Added** - Menu.java, that creates a interactive window to search the mp3 file, and the options to hide/show the message<br>
**Added** - Main.java, that contains the main() method, and calls Menu.java<br>
**Fixed** - unexpected null pointer exception on ID3.java
> *now the method getFrameMensagem() check if the frame is null*<br>

**Removed** - Vigenere.java, since the message will be stored as is, without encrypting methods<br>
**Removed** - Esteganografia.java, since the main method was moved to another class<br>

steganomaker 0.2.1, 2016-03-18
-
**Fixed** - problem with I/O flux, since ID3.java wasn't saving changes on the mp3 file<br>
**Fixed** - wrong coupling through Vigenere.java and ID3.java<br>
**Fixed** - unexpected null pointer exception when trying to overwrite the message on the tag<br>

steganomaker 0.2.0, 2016-03-18
-
**Added** - ID3.java, that makes all mp3 data manipulation<br>

steganomaker 0.1.0, 2016-03-17
-
**Added** - Vigenere.java, that implements <a href="https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher">Vigenère Cipher</a> for encoding<br>
**Added** - Esteganografia.java, that contains main method
