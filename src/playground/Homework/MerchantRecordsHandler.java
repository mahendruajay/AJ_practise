package playground.Homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains all the operations to handle merchant records in a
 * particular file. These operations include - finding of a merchant record by
 * merchant id. - finding of merchant records by merchant name. - adding a new
 * merchant record. - updating an existing merchant record.
 * <p>
 * Apart from these it also contains operations to open a file and commit to a
 * file.
 * <p>
 * To use this class, one needs to create an instance of this class using the
 * constructor passing it the name of the file. For example:
 * MerhcantRecordsHandler(<fileName>)
 * <p>
 * Once the instance have been created the user has to call the openFile()
 * method to read the file and populate the Map data structures.
 *
 * @author Ajay Mahendru
 */
public class MerchantRecordsHandler {
    /* Indicates whether the file is already read, and the Maps created */
    private boolean fileAlreadyRead = false;

    /*
     * Indicates whether any records are modified. In other words the
     * addMerchant() and updateMerchantrecord() methods returned true.
     */
    private boolean recordsModified = false;

    /*
     * Map to store a merchant record corresponding to a unique merchant id as a
     * key. This map is used to search a merchant record by merchant id.
     *
     * key - merchant id value - merchant record
     */
    private Map<String, MerchantRecord> mapByMerchantID = new HashMap<String, MerchantRecord>();

    /*
     * Map to store a list of merchant ids, corressponding to a merchant name as
     * a key. This map is used to find the list of merchant ids, given a
     * merchant name. The id in the list of ids in turn is used to find a
     * merchant record using the mapByMerchantID Map. (Multiple records can have
     * the same merchant name)
     *
     * key - merchant name value - list of merchant ids
     */
    private Map<String, List<String>> mapByMerchantName = new HashMap<String, List<String>>();

    // Name of the file that contains the merchant records.
    private String fileName;

    // Constructor
    public MerchantRecordsHandler(String fileName) {
        this.fileName = fileName;
    }

    /*
     * This method opens the file containing the merchant records, read the
     * records line by line, and stores each record in the two maps:
     * mapByMerchantID and mapByMerchantName.
     *
     * This process runs only once, if the first call to openFile() returned
     * true. If the first call to openFile() returned true, then successive
     * calls to open file will still return true, but the file is not read from
     * the disk again.
     *
     * @return - Returns true if the openFile operation was successful,
     * otherwise returns false.
     */
    public boolean openFile() {
        // Indicates fileName exists and file has not been read already.
        if (null != fileName && !fileAlreadyRead) {
            File file = new File(fileName);
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);

                // Read records from the file line by line.
                String recordLine;
                while ((recordLine = bufferedReader.readLine()) != null) {
                    /*
                     * Create a scanner for each line read, and use the
					 * delimiter as ","
					 */
                    Scanner lineScanner = new Scanner(recordLine);
                    lineScanner.useDelimiter(",");

					/*
					 * String array to get the four tokens from a line/record.
					 * Here, token[0] - merchant name token[1] - merchant id
					 * token[2] - phone number token[3] - contact name
					 */
                    String[] tokens = new String[4];

					/*
					 * Collect each token and store it in the tokens array, to
					 * be used later to create a merchant record.
					 */
                    int i = 0;
                    while (lineScanner.hasNext()) {
                        tokens[i] = lineScanner.next();
                        i++;
                    }

					/*
					 * Create a merchant records using the tokens. Here,
					 * token[0] - merchant name token[1] - merchant id token[2]
					 * - phone number token[3] - contact name
					 */
                    MerchantRecord merRecord = new MerchantRecord(tokens[0],
                            tokens[1], tokens[2], tokens[3]);

					/*
					 * Put each record in the mapByMerchantID HashMap, with the
					 * key as the merchant id, if the key does not exist already
					 * in the map. If the key already exist in the map then the
					 * current record read is a duplicate.
					 * 
					 * Here, token[1] - merchant id
					 */

                    if (!mapByMerchantID.containsKey(tokens[1])) {
                        mapByMerchantID.put(tokens[1], merRecord);

						/*
						 * The mapByMerchantName HashMap stores the list of
						 * merchant ids, with the key as the merchant name.
						 * 
						 * For a given record and given merchant name in that
						 * record, if there is no entry existing in the HashMap
						 * then create a new list for merchant ids and store the
						 * merchant id for the current record in the list and
						 * store the list itself as a value in the HashMap, with
						 * the key as the merchant name for the current record.
						 * 
						 * For a given record and given merchant name in that
						 * record, if there is exists an entry in the HashMap
						 * then add the merchant id for the current record in
						 * the merchant id list stored at the current HashMap
						 * entry.
						 */
                        if (!mapByMerchantName.containsKey(tokens[0])) {
                            List<String> ids = new ArrayList<String>();
                            ids.add(tokens[1]);
                            mapByMerchantName.put(tokens[0], ids);
                        } else {
                            List<String> ids = mapByMerchantName.get(tokens[0]);
                            ids.add(tokens[1]);
                            mapByMerchantName.put(tokens[0], ids);
                        }
                    } else {
                        if (Logger.getLogger(
                                MerchantRecordsHandler.class.getName())
                                .isLoggable(Level.INFO)) {
                            String logMessage = "Duplicate record for merchant id: "
                                    + tokens[1];
                            Logger.getLogger(
                                    MerchantRecordsHandler.class.getName())
                                    .log(Level.INFO, logMessage);
                        }
                    }
                }
                fileAlreadyRead = true;
                return true;
            } catch (FileNotFoundException ex) {
                if (Logger.getLogger(MerchantRecordsHandler.class.getName())
                        .isLoggable(Level.SEVERE)) {
                    String exceptiomMessage = "File : " + fileName
                            + "not found.";
                    Logger.getLogger(MerchantRecordsHandler.class.getName())
                            .log(Level.SEVERE, exceptiomMessage, ex);
                }
                return false;
            } catch (IOException ex) {
                if (Logger.getLogger(MerchantRecordsHandler.class.getName())
                        .isLoggable(Level.SEVERE)) {
                    String exceptonMessage = "IOException occurred while reading file : "
                            + fileName;
                    Logger.getLogger(MerchantRecordsHandler.class.getName())
                            .log(Level.SEVERE, exceptonMessage, ex);
                }
                return false;
            } finally {
                try {
                    fileReader.close();
                    bufferedReader.close();
                } catch (IOException ex) {
                    if (Logger
                            .getLogger(MerchantRecordsHandler.class.getName())
                            .isLoggable(Level.SEVERE)) {
                        Logger.getLogger(MerchantRecordsHandler.class.getName())
                                .log(Level.SEVERE, "IOException",
                                        ex.getMessage());
                    }
                }
            }

        }
		/*
		 * If file was read already, still return true indicating that nothing
		 * was wrong
		 */
        if (fileAlreadyRead) {
            return true;
        }

        return false;
    }

    /*
     * Finds a particular merchant record for a given merchant id.
     *
     * @param merchantID - Finds a record by merchant id.
     *
     * @return - Returns the merchant record if found, otherwise returns null.
     */
    public MerchantRecord findMerchantByID(String merchantID) {
        MerchantRecord merchantRecord = null;
        merchantRecord = mapByMerchantID.get(merchantID);
        return merchantRecord;
    }

    /*
     * Finds one or more merchant records for a given merchant name. (Multiple
     * records can have the same merchant name)
     *
     * @param merchantName - finds merchant records by merchant name.
     *
     * @return - Returns a list containing one or more merchant records if
     * found, otherwise returns null.
     */
    public List<MerchantRecord> findMerchantByName(String merchantName) {
        List<MerchantRecord> merchantRecords = null;
        List<String> merIds = null;
        merIds = mapByMerchantName.get(merchantName);
        if (null != merIds) {
            merchantRecords = new ArrayList<MerchantRecord>();
            for (String merID : merIds) {
                MerchantRecord merRec = mapByMerchantID.get(merID);
                if (null != merRec) {
                    merchantRecords.add(merRec);
                }
            }

        }
        return merchantRecords;
    }

    /*
     * Adds a merchant record, if it does not already exist in the file. As
     * merchantd id is unique, if the merchant id of the merchant record to be
     * added, already exists, then its a duplicate and it is not added.
     *
     * @param merchantrecord - The merchant record to be added.
     *
     * @return - Returns true if the record is added, otherwise returns false.
     */
    public boolean addMerchant(MerchantRecord merchantRecord) {
        if (!mapByMerchantID.containsKey(merchantRecord.getMerchantID())) {
            mapByMerchantID.put(merchantRecord.getMerchantID(), merchantRecord);
            recordsModified = true;
            return true;
        } else {
            if (Logger.getLogger(MerchantRecordsHandler.class.getName())
                    .isLoggable(Level.INFO)) {
                String logMessage = "Duplicate record for merchant id: "
                        + merchantRecord.getMerchantID();
                Logger.getLogger(MerchantRecordsHandler.class.getName()).log(
                        Level.INFO, logMessage);
            }
            return false;
        }

    }

    /*
     * Updates a merchant record for a given merchant id. If the merchant record
     * for a given merchant id exists in the file, then the merchant name,
     * and/or phone number and/or the contact name for that record can be
     * updated.
     *
     * A value of null can be passed for the field if it is not to be updated.
     * For example: if a null value is passed for phoneNumber and contact name,
     * then only the merchant name will be updated with the value of the
     * merchant name field passed through this function. The original values of
     * phoneNumber and contact name on the record will remain as it is.
     *
     * If the merchant name is updated, we have update both maps mapByMerchantID
     * and mapByMerchantName accordingly.
     *
     * @param merchantID - the id of the merchant whose record is to be updated.
     * merchantName - the merchant name to be updated. phoneNumber - the phone
     * number to be updated. contactName - the contact name to be updated.
     *
     * @return - Returns true, if the record is updated, otherwise returns false
     * if no record found for the given merchant id or there is no value to
     * update.
     */
    public boolean updateMerchantRecord(String merchantID, String merchantName,
                                        String phoneNumber, String contactName) {
		/* Indicates that there is at least one field that needs to be updated */
        boolean someFieldToUpdate = false;

		/* Retrieve the current record */
        MerchantRecord merRec = mapByMerchantID.get(merchantID);

        // If a record exists for a given merchant id
        if (null != merRec) {
			/* String to store the current merchant name in the record */
            String previousMerchantName = null;

            if (null != merchantName
                    && (!merchantName.equals(merRec.getMerchantName()))) {
				/*
				 * Case where merchant name needs to be updated. In this case we
				 * need to capture the current value of merchant name, before we
				 * update it.
				 */
                previousMerchantName = merRec.getMerchantName();
                merRec.setMerchantName(merchantName);
                someFieldToUpdate = true;
            }
            if (null != phoneNumber
                    && (!phoneNumber.equals(merRec.getPhoneNumber()))) {
                merRec.setPhoneNumber(phoneNumber);
                someFieldToUpdate = true;
            }
            if (null != contactName
                    && (!contactName.equals(merRec.getMerchantContact()))) {
                merRec.setMerchantContact(contactName);
                someFieldToUpdate = true;
            }

			/* Atleast one field is updated */
            if (someFieldToUpdate) {
				/*
				 * Case where merchant name was updated. In this case we need to
				 * update the values in the mapByMerchantName HashMap.
				 * 
				 * For example we have two values of merchant names: -
				 * previousName and - updatedName
				 * 
				 * Then we retrieve the list of ids using the previous name from
				 * the mapByMerchantName HashMap, and remove the merchant id
				 * corresponding to the previousName from the list. If this list
				 * is empty after this operation we remove the entry for the
				 * previousName from the mapByMerchantName HashMap. If the list
				 * is not empty we update the entry for previousName in the
				 * mapByMerchantName HashMap with the updated list of merchant
				 * ids.
				 * 
				 * In the next step, we update the entries for updatedName in
				 * the mayByMerchantName HashMap.
				 */
                if (null != merchantName) {
					/*
					 * Update the entries in mapByMerchantName Hashmap for
					 * previousMerchantName
					 */
                    List<String> idsList = mapByMerchantName
                            .get(previousMerchantName);
                    idsList.remove(merchantID);
                    if (idsList.isEmpty()) {
                        mapByMerchantName.remove(previousMerchantName);
                    } else {
                        mapByMerchantName.put(previousMerchantName, idsList);
                    }

					/*
					 * Update the entries in mapByMerchantName for the updated
					 * merchantName
					 */
                    if (!mapByMerchantName.containsKey(merchantName)) {
                        List<String> ids = new ArrayList<String>();
                        ids.add(merchantID);
                        mapByMerchantName.put(merchantName, ids);
                    } else {
                        List<String> ids = mapByMerchantName.get(merchantName);
                        ids.add(merchantID);
                        mapByMerchantName.put(merchantName, ids);
                    }

                }

				/* finally update the merchantRecord for the given merchantID */
                mapByMerchantID.put(merchantID, merRec);

				/* Mark recordsModified as true */
                recordsModified = true;
                return true;
            } else {
                // The values of all the fields to be updated were null.

                if (Logger.getLogger(MerchantRecordsHandler.class.getName())
                        .isLoggable(Level.INFO)) {
                    String logMessage = "No values to update the given merchant id : "
                            + merchantID;
                    Logger.getLogger(MerchantRecordsHandler.class.getName())
                            .log(Level.INFO, logMessage);
                }
                return false;
            }
        } else {
            // The merchantID for which the record was to be updated was not
            // found.

            if (Logger.getLogger(MerchantRecordsHandler.class.getName())
                    .isLoggable(Level.INFO)) {
                String logMessage = "No record found with the given merchant id : "
                        + merchantID;
                Logger.getLogger(MerchantRecordsHandler.class.getName()).log(
                        Level.INFO, logMessage);
            }
            return false;
        }

    }

    /*
     * Commit the changes to records, if any to the file on the disk.
     *
     * The strategy used here is to rename the original file to some backup
     * file, and then commit the records to a new file named as the original
     * file. If the backup file already exists, it is first deleted, before
     * renaming the original file to the backup file.
     *
     * Hence all the commits as stored in a file names as the original file
     * name.
     *
     * @return - Returns true if all the changes were commited to the file,
     * otherwisse returns false. If the commits fial for some reason, the backup
     * file always has the earlier commits.
     */
    public boolean commitFile() {
        // Commit only if any records are modified.
        if (recordsModified) {
            if (null != fileName) {
                boolean fileDelete = false;

				/*
				 * Create a backup file name, by extending the original file
				 * name with a ".bak"
				 */
                String backupfileName = fileName + ".bak";

                // two file references: one for original file and other for
                // backup file.
                File file = new File(fileName);
                File backupFile = new File(backupfileName);

                // If backup file name already exists then it is deleted first.
                if (backupFile.exists()) {
                    fileDelete = backupFile.delete();
                }

                // The original file is then renamed to backup file name.
                file.renameTo(backupFile);

                PrintWriter printWriter = null;
                File newFile = new File(fileName);

                // Start writing to the file.
                try {
                    printWriter = new PrintWriter(newFile);
                    String delim = ",";
                    StringBuilder recordToWrite = new StringBuilder();

					/*
					 * Print each record from the mapByMerchantID Hashmap.
					 */
                    for (MerchantRecord merchantRecord : mapByMerchantID
                            .values()) {
                        recordToWrite.append(merchantRecord.getMerchantName());
                        recordToWrite.append(delim);
                        recordToWrite.append(merchantRecord.getMerchantID());
                        recordToWrite.append(delim);
                        recordToWrite.append(merchantRecord.getPhoneNumber());
                        recordToWrite.append(delim);
                        recordToWrite.append(merchantRecord
                                .getMerchantContact());
                        printWriter.println(recordToWrite.toString());

                        recordToWrite.setLength(0);
                    }
                    // Mark the recordsModified flag as false again.
                    recordsModified = false;
                    return true;
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MerchantRecordsHandler.class.getName())
                            .log(Level.SEVERE, null, ex);
                    return false;
                } finally {
                    printWriter.close();
                }
            }

        }

        // If nothing was changed then do not commit anything.
        return false;
    }

}
