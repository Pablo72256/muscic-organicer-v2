            import java.util.ArrayList;
            
            /**
             * A class to hold details of audio files.
             * This version can play the files.
             * 
             * @author David J. Barnes and Michael KÃ¶lling
             * @version 2011.07.31
             */
            public class MusicOrganizer
            {
                // An ArrayList for storing the file names of music files.
                private ArrayList<String> files;
                // A player for the music files.
                private MusicPlayer player;
                    
                /**
                 * Create a MusicOrganizer
                 */
                public MusicOrganizer()
                {
                    files = new ArrayList<String>();
                    player = new MusicPlayer();
                }
                
                /**
                 * Add a file to the collection.
                 * @param filename The file to be added.
                 */
                public void addFile(String filename)
                {
                    files.add(filename);
                }
                
                /**
                 * Return the number of files in the collection.
                 * @return The number of files in the collection.
                 */
                public int getNumberOfFiles()
                {
                    return files.size();
                }
                
                /**
                 * List a file from the collection.
                 * @param index The index of the file to be listed.
                 */
                public void listFile(int index)
                {
                    if(index >= 0 && index < files.size()) {
                        String filename = files.get(index);
                        System.out.println(filename);
                    }
                }
                
                /**
                 * Remove a file from the collection.
                 * @param index The index of the file to be removed.
                 */
                public void removeFile(int index)
                {
                    if(index >= 0 && index < files.size()) {
                        files.remove(index);
                    }
                }
            
                /**
                 * Start playing a file in the collection.
                 * Use stopPlaying() to stop it playing.
                 * @param index The index of the file to be played.
                 */
                public void startPlaying(int index)
                {
                    String filename = files.get(index);
                    player.startPlaying(filename);
                }
            
                /**
                 * Stop the player.
                 */
                public void stopPlaying()
                {
                    player.stop();
                }
                
                /**
                 * Listar todos los elementos de la coleccion.
                */
                public void listAllFiles(){
                    int contador = 0;
                    while (contador < files.size()){
                       String filename = files.get(contador);
                       contador++;
                       System.out.println(contador + ". " + filename);
                    }
                    
                }
                
                /**
                 * Listar todos los elementos con un String pasado como parametro
                */
                public void listMaching(String searchString){
                    boolean elTextoCoincide = false;
                    for (String filename : files) {
                        if (filename.contains(searchString)){
                            System.out.println(filename);
                            elTextoCoincide = true;
                        }
                    }
                    if (elTextoCoincide == false) {
                        System.out.println("No se encuentra "+ searchString + " en en array");
                    }
                }
                
                /**
                 * Reproducir los primeros segundos de una cancion pasado un artista como parametro
                */
                public void playSamplesArtist (String searchString) {
                    for (String filename : files) {
                        if (filename.contains(searchString)){
                            player.playSample(filename);
                        }
                    }
                }
                
                /**
                 * Localiza el índice del primer archivo que se corresponde con
                 * la cadena de búsqueda indicada .
                 * @param searchString La cadena que hay que buscar.
                 * @return El índice de la primera aparición o -1 si
                 * no se encuentra ninguna correspondencia
                 */
                public int findFirst(String searchString){
                    int indice = 0;
                    int resultado = -1;
                    boolean elTextoCoincide = true;
                    while (indice < files.size()){
                        if (elTextoCoincide){
                            String filename = files.get(indice);
                            if (filename.contains(searchString)){
                                elTextoCoincide = false;
                                resultado = indice;
                            }
                            else{
                                indice ++;
                            } 
                        }
                        else {
                            indice = files.size();
                        }
                    }
                    return resultado;
                }
            }
