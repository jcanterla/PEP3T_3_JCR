import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class PEP3T_3_JCR {
    private static DocumentBuilderFactory factoriaDoc;
    private static DocumentBuilder constructDoc;
    private static Document docDOM;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        File fichXML = new File("src/peliculas.xml");
        try {
            factoriaDoc = DocumentBuilderFactory.newInstance();
            constructDoc = factoriaDoc.newDocumentBuilder();
            docDOM = constructDoc.parse(fichXML);

        } catch (Exception e) {
            e.printStackTrace();
        }

        do {
            System.out.println("==========================");
            System.out.println("PROGRAMA GESTIÓN PELÍCULAS");
            System.out.println("==========================");
            System.out.println("1) Presentar el documento XML completo");
            System.out.println("2) Añadir nuevo nodo al documento");
            System.out.println("3) Modificar datos de un nodo del documento");
            System.out.println("4) Eliminar un nodo concreto del documento");
            System.out.println("5) Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    presentarDocumento();
                    break;
                case 2:
                    añadirNodo();
                    break;
                case 3:
                    modificarNodo();
                    break;
                case 4:
                    eliminarNodo();
                    break;
            }
        } while (opcion != 5);
    }

    private static void presentarDocumento() {
        try {
            TransformerFactory factoriaTrans = TransformerFactory.newInstance();
            Transformer transformador = factoriaTrans.newTransformer();
            transformador.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource origenDOM = new DOMSource(docDOM);
            StreamResult destino = new StreamResult(System.out);
            transformador.transform(origenDOM, destino);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void añadirNodo() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1) Insertar nodo al principio del documento");
            System.out.println("2) Insertar nodo en posiciones intermedias del documento");
            System.out.println("3) Insertar nodo al final del documento");
            System.out.println("4) Volver al menú principal");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    insertarNodoAlPrincipio();
                    break;
                case 2:
                    insertarNodoEnPosicionesIntermedias();
                    break;
                case 3:
                    insertarNodoAlFinal();
                    break;
            }
        } while (opcion != 4);
    }

    private static void insertarNodoAlPrincipio() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el título de la película:");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el guionista de la película:");
        String guionista = scanner.nextLine();
        System.out.print("Introduce la productora de la película:");
        String productora = scanner.nextLine();
        System.out.print("Introduce el director de la película:");
        String director = scanner.nextLine();
        System.out.print("Introduce el actor de la película:");
        String actor = scanner.nextLine();
        System.out.print("Introduce la sinopsis de la película:");
        String sinopsis = scanner.nextLine();

        try {
            Element nuevaPelicula = docDOM.createElement("pelicula");
            Element Titulo = docDOM.createElement("titulo");
            Titulo.appendChild(docDOM.createTextNode(titulo));
            Element Guionista = docDOM.createElement("guionista");
            Guionista.appendChild(docDOM.createTextNode(guionista));
            Element Productora = docDOM.createElement("productora");
            Productora.appendChild(docDOM.createTextNode(productora));
            Element Director = docDOM.createElement("director");
            Director.appendChild(docDOM.createTextNode(director));
            Element Actor = docDOM.createElement("actor");
            Actor.appendChild(docDOM.createTextNode(actor));
            Element Sinopsis = docDOM.createElement("sinopsis");
            Sinopsis.appendChild(docDOM.createTextNode(sinopsis));

            nuevaPelicula.appendChild(Titulo);
            nuevaPelicula.appendChild(Guionista);
            nuevaPelicula.appendChild(Productora);
            nuevaPelicula.appendChild(Director);
            nuevaPelicula.appendChild(Actor);
            nuevaPelicula.appendChild(Sinopsis);

            Node root = docDOM.getDocumentElement();
            Node firstChild = root.getFirstChild();
            root.insertBefore(nuevaPelicula, firstChild);

            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult result = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertarNodoEnPosicionesIntermedias() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indica la posición dentro del documento: ");
        int posicion = scanner.nextInt();

        System.out.print("Introduce el título de la película:");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el guionista de la película:");
        String guionista = scanner.nextLine();
        System.out.print("Introduce la productora de la película:");
        String productora = scanner.nextLine();
        System.out.print("Introduce el director de la película:");
        String director = scanner.nextLine();
        System.out.print("Introduce el actor de la película:");
        String actor = scanner.nextLine();
        System.out.print("Introduce la sinopsis de la película:");
        String sinopsis = scanner.nextLine();

        try {
            Element nuevaPelicula = docDOM.createElement("pelicula");
            Element Titulo = docDOM.createElement("titulo");
            Titulo.appendChild(docDOM.createTextNode(titulo));
            Element Guionista = docDOM.createElement("guionista");
            Guionista.appendChild(docDOM.createTextNode(guionista));
            Element Productora = docDOM.createElement("productora");
            Productora.appendChild(docDOM.createTextNode(productora));
            Element Director = docDOM.createElement("director");
            Director.appendChild(docDOM.createTextNode(director));
            Element Actor = docDOM.createElement("actor");
            Actor.appendChild(docDOM.createTextNode(actor));
            Element Sinopsis = docDOM.createElement("sinopsis");
            Sinopsis.appendChild(docDOM.createTextNode(sinopsis));

            nuevaPelicula.appendChild(Titulo);
            nuevaPelicula.appendChild(Guionista);
            nuevaPelicula.appendChild(Productora);
            nuevaPelicula.appendChild(Director);
            nuevaPelicula.appendChild(Actor);
            nuevaPelicula.appendChild(Sinopsis);

            Node root = docDOM.getDocumentElement();
            Node targetNode = root.getChildNodes().item(posicion);
            root.insertBefore(nuevaPelicula, targetNode);

            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult result = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertarNodoAlFinal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el título de la película:");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el guionista de la película:");
        String guionista = scanner.nextLine();
        System.out.print("Introduce la productora de la película:");
        String productora = scanner.nextLine();
        System.out.print("Introduce el director de la película:");
        String director = scanner.nextLine();
        System.out.print("Introduce el actor de la película:");
        String actor = scanner.nextLine();
        System.out.print("Introduce la sinopsis de la película:");
        String sinopsis = scanner.nextLine();

        try {
            Element nuevaPelicula = docDOM.createElement("pelicula");
            Element Titulo = docDOM.createElement("titulo");
            Titulo.appendChild(docDOM.createTextNode(titulo));
            Element Guionista = docDOM.createElement("guionista");
            Guionista.appendChild(docDOM.createTextNode(guionista));
            Element Productora = docDOM.createElement("productora");
            Productora.appendChild(docDOM.createTextNode(productora));
            Element Director = docDOM.createElement("director");
            Director.appendChild(docDOM.createTextNode(director));
            Element Actor = docDOM.createElement("actor");
            Actor.appendChild(docDOM.createTextNode(actor));
            Element Sinopsis = docDOM.createElement("sinopsis");
            Sinopsis.appendChild(docDOM.createTextNode(sinopsis));

            nuevaPelicula.appendChild(Titulo);
            nuevaPelicula.appendChild(Guionista);
            nuevaPelicula.appendChild(Productora);
            nuevaPelicula.appendChild(Director);
            nuevaPelicula.appendChild(Actor);
            nuevaPelicula.appendChild(Sinopsis);

            Node root = docDOM.getDocumentElement();
            root.appendChild(nuevaPelicula);

            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult result = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void modificarNodo() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1) Modificar nodo al principio del documento");
            System.out.println("2) Modificar nodo en posiciones intermedias del documento");
            System.out.println("3) Modificar nodo al final del documento");
            System.out.println("4) Volver al menú principal");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    modificarNodoAlPrincipio();
                    break;
                case 2:
                    modificarNodoEnPosicionesIntermedias();
                    break;
                case 3:
                    modificarNodoAlFinal();
                    break;
            }
        } while (opcion != 4);
    }

    private static void modificarNodoAlPrincipio() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Titulo 4) Director");
        System.out.println("2) Guionista 5) Actor");
        System.out.println("3) Productora 6) Sinopsis");
        System.out.println("7) Volver al menú anterior");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduce el nuevo valor: ");
        String newValue = scanner.nextLine();

        Node root = docDOM.getDocumentElement();
        Node pelicula = root.getFirstChild();
        Element peliculaElement = (Element) pelicula;

        switch (opcion) {
            case 1:
                peliculaElement.getElementsByTagName("titulo").item(0).setTextContent(newValue);
                break;
            case 2:
                peliculaElement.getElementsByTagName("guionista").item(0).setTextContent(newValue);
                break;
            case 3:
                peliculaElement.getElementsByTagName("productora").item(0).setTextContent(newValue);
                break;
            case 4:
                peliculaElement.getElementsByTagName("director").item(0).setTextContent(newValue);
                break;
            case 5:
                peliculaElement.getElementsByTagName("actor").item(0).setTextContent(newValue);
                break;
            case 6:
                peliculaElement.getElementsByTagName("sinopsis").item(0).setTextContent(newValue);
                break;
            case 7:
                return;
        }

        try {
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult result = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void modificarNodoEnPosicionesIntermedias() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indica el título de la película: ");
        String tituloBuscado = scanner.nextLine();

        System.out.println("1) Titulo 4) Director");
        System.out.println("2) Guionista 5) Actor");
        System.out.println("3) Productora 6) Sinopsis");
        System.out.println("7) Volver al menú anterior");
        System.out.print("Opción: ");
        int dato = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduce el nuevo valor: ");
        String newValue = scanner.nextLine();

        Node root = docDOM.getDocumentElement();
        NodeList peliculas = root.getChildNodes();

        for (int i = 0; i < peliculas.getLength(); i++) {
            Node pelicula = peliculas.item(i);
            Element peliculaElement = (Element) pelicula;
            String titulo = peliculaElement.getElementsByTagName("titulo").item(0).getTextContent();

            if (titulo.equals(tituloBuscado)) {
                switch (dato) {
                    case 1:
                        peliculaElement.getElementsByTagName("titulo").item(0).setTextContent(newValue);
                        break;
                    case 2:
                        peliculaElement.getElementsByTagName("guionista").item(0).setTextContent(newValue);
                        break;
                    case 3:
                        peliculaElement.getElementsByTagName("productora").item(0).setTextContent(newValue);
                        break;
                    case 4:
                        peliculaElement.getElementsByTagName("director").item(0).setTextContent(newValue);
                        break;
                    case 5:
                        peliculaElement.getElementsByTagName("actor").item(0).setTextContent(newValue);
                        break;
                    case 6:
                        peliculaElement.getElementsByTagName("sinopsis").item(0).setTextContent(newValue);
                        break;
                    case 7:
                        return;
                }
                break;
            }
        }

        try {
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult result = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, result);
            System.out.println("El nodo ha sido modificado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void modificarNodoAlFinal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Titulo 4) Director");
        System.out.println("2) Guionista 5) Actor");
        System.out.println("3) Productora 6) Sinopsis");
        System.out.println("7) Volver al menú anterior");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Introduce el nuevo valor: ");
        String newValue = scanner.nextLine();

        Node root = docDOM.getDocumentElement();
        Node pelicula = root.getLastChild();
        Element peliculaElement = (Element) pelicula;

        switch (opcion) {
            case 1:
                peliculaElement.getElementsByTagName("titulo").item(0).setTextContent(newValue);
                break;
            case 2:
                peliculaElement.getElementsByTagName("guionista").item(0).setTextContent(newValue);
                break;
            case 3:
                peliculaElement.getElementsByTagName("productora").item(0).setTextContent(newValue);
                break;
            case 4:
                peliculaElement.getElementsByTagName("director").item(0).setTextContent(newValue);
                break;
            case 5:
                peliculaElement.getElementsByTagName("actor").item(0).setTextContent(newValue);
                break;
            case 6:
                peliculaElement.getElementsByTagName("sinopsis").item(0).setTextContent(newValue);
                break;
            case 7:
                return;
        }

        try {
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult result = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, result);
            System.out.println("El nodo ha sido modificado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void eliminarNodo() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1) Eliminar nodo al principio del documento");
            System.out.println("2) Eliminar nodo en posiciones intermedias del documento");
            System.out.println("3) Eliminar nodo al final del documento");
            System.out.println("4) Volver al menú principal");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    eliminarNodoAlPrincipio();
                    break;
                case 2:
                    eliminarNodoEnPosicionesIntermedias();
                    break;
                case 3:
                    eliminarNodoAlFinal();
                    break;
            }
        } while (opcion != 4);
    }

    private static void eliminarNodoAlPrincipio() {
        Node root = docDOM.getDocumentElement();
        Node firstChild = root.getFirstChild();
        root.removeChild(firstChild);

        try {
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult result = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void eliminarNodoEnPosicionesIntermedias() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indica el título de la película: ");
        String tituloBuscado = scanner.nextLine();

        Node root = docDOM.getDocumentElement();
        NodeList peliculas = root.getChildNodes();

        for (int i = 0; i < peliculas.getLength(); i++) {
            Node pelicula = peliculas.item(i);
            Element peliculaElement = (Element) pelicula;
            String titulo = peliculaElement.getElementsByTagName("titulo").item(0).getTextContent();

            if (titulo.equals(tituloBuscado)) {
                root.removeChild(pelicula);
                break;
            }
        }

        try {
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult result = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, result);
            System.out.println("El nodo ha sido eliminado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void eliminarNodoAlFinal() {
        Node root = docDOM.getDocumentElement();
        Node lastChild = root.getLastChild();
        root.removeChild(lastChild);

        try {
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult result = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, result);
            System.out.println("El nodo ha sido eliminado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}