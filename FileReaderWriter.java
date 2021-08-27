package Com.CodeBind;

public class FileReaderWriter {
	public void writeData(String filePath, Hashtable<String, ArrayList<ContactDetails>> contactInfo){
        StringBuffer empBuffer = new StringBuffer();

        contactInfo.forEach((companyName,contactDetails) ->{
            String empDataString = companyName.concat(contactDetails.toString().concat("\n"));
            empBuffer.append(empDataString);
        });

        try {
            Files.write(Paths.get(filePath),empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * : To read data from file
     *
     * filePath path of file
     */
    public void readData(String filePath){
        try {
            Files.lines(new File(filePath).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

