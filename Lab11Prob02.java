/*
 * File: Lab11Prob02.java
 * Class: CSCI1302A
 * Author: David Mbadinga
 * Last modified: Nov 23, 2024
 */        
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
                  public class Lab11Prob02 {
                    public static void main(String[] args) {
                          String inputFilePath = "src/people.dat";
                          String outputFilePath = "src/people-salary-sorted.dat";
                             ArrayList<Person> persons = new ArrayList<>();

                                // Read data from file and create Person objects
                                try (DataInputStream dis = new DataInputStream(new FileInputStream(inputFilePath))) {
                                    while (true) {
                                        try {
                                            int age = dis.readInt();
                                            String name = dis.readUTF();
                                            String address = dis.readUTF();
                                            int zipCode = dis.readInt();
                                            double salary = dis.readDouble();

                                            // Create a Person object and add to the ArrayList
                                            Person person = new Person(age, name, address, zipCode, salary);
                                            persons.add(person);
                                        } catch (EOFException eof) {
                                            break; // End of file reached
                                        }
                                    }
                                } catch (FileNotFoundException fnfe) {
                                    System.err.println("File not found: " + fnfe.getMessage());
                                } catch (IOException ioe) {
                                    System.err.println("I/O error: " + ioe.getMessage());
                                }

                                // Sort the ArrayList by salary in descending order
                                Collections.sort(persons);

                                // Write sorted data to the output file
                                try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                                    for (Person person : persons) {
                                        writer.write(person.toString());
                                        writer.newLine();
                                    }
                                } catch (IOException ioe) {
                                    System.err.println("I/O error: " + ioe.getMessage());
                                }

                                // Read and display the sorted file content
                                try (BufferedReader reader = new BufferedReader(new FileReader(outputFilePath))) {
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        System.out.println(line); // Print each line to console
                                    }
                                } catch (IOException ioe) {
                                    System.err.println("I/O error while reading the sorted file: " + ioe.getMessage());
                                }
                            }
                        }
