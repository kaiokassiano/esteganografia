# Esteganografia

O objetivo desse projeto é proporcionar um modo de realização de <a href="https://en.wikipedia.org/wiki/Steganography">Esteganografia</a> em áudio. Feito em Java, basta fornecer uma mensagem que o programa realizará os processos de encriptação, de acordo com uma chave pré-definida, usando os princípios da <a href="https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher">Cifra de Vigenère</a>. Após isso, o programa editará a <a href="https://en.wikipedia.org/wiki/ID3">ID3</a> do arquivo de áudio, ocultando a mensagem criptografada dentro do arquivo. O processo inverso(decriptação) também pode ser realizado.

## Considerações

O programa depende da biblioteca <a href="http://javamusictag.sourceforge.net/">jid3lib</a> para funcionar corretamente. Você pode encontrá-la <a href="http://javamusictag.sourceforge.net/download.htm">aqui</a>.
