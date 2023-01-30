/**
 *
 * @author Johannes
 */
import java.util.HashMap;

public class visma_program {
    /**
     * @param args the command line arguments
     */
        public static HashMap<String, HashMap> identify(String[] args){
            HashMap<String, HashMap> path_and_parameter = new HashMap<>(); // This is where we store path and parameters
            String[] scheme = args[0].split(":");                       //Saving the name of the scheme
            if(scheme[0].equals("visma-identity")){                     //If scheme is the right one and a string we continue
                String[] path = scheme[1].substring(2).split("\\?");    //Saving the name of the path
                if(path[0].equals("login") || path[0].equals("confirm") //Checking that path is one of the allowed and a string
                        || path[0].equals("sign")){
                    if(path[0].equals("login")){
                        HashMap<String, String> parameters = new HashMap<>(); //Creating new HashMap for parameters
                        String[] parameter = path[1].split("=");        //Splitting the whole parameter into key and value
                        parameters.put(parameter[0], parameter[1]);     //Adding parameters to the HashMap
                        path_and_parameter.put(path[0], parameters);
                        return path_and_parameter;                      //Returning path and parameter
                    }
                    if(path[0].equals("confirm")){
                        HashMap<String, String> parameters = new HashMap<>(); //Creating new HashMap for parameters
                        String[] parameter1 = path[1].split("=");           //Splitting the whole parameter into key and value
                        String[] parameter2 = parameter1[1].split("\\&");
                        parameters.put(parameter1[0], parameter2[0]);       //Adding parameters to the HashMap
                        parameters.put(parameter2[1], parameter1[2]);       //Adding parameters to the HashMap
                        path_and_parameter.put(path[0], parameters);
                        return path_and_parameter;                          //Returning path and parameter
                    }
                    if(path[0].equals("sign")){
                        HashMap<String, String> parameters = new HashMap<>(); //Creating new HashMap for parameters
                        String[] parameter1 = path[1].split("=");           //Splitting the whole parameter into key and value
                        String[] parameter2 = parameter1[1].split("\\&");
                        parameters.put(parameter1[0], parameter2[0]);       //Adding parameters (source and value) to the HashMap
                        parameters.put(parameter2[1], parameter1[2]);       //Adding parameters (documentid and value) to the HashMap
                        path_and_parameter.put(path[0], parameters);
                        return path_and_parameter;                          //Returning path and parameter
                    }
                }
                else{
                    System.out.println("Path is invalid!"); //Notifying user Path was invalid
                }
            }
            else{
                System.out.println("Scheme is invalid!");   //Notifying user Scheme was invalid
            }
            return path_and_parameter;          //Returning path and parameter
        }
    
    public static void main(String[] args){
        HashMap<String, HashMap> path_and_parameter = identify(args);   /*Sending args to method identify() and saving them to HashMap,
                                                                        identify() will return path and parameters in HashMap*/
    }
}