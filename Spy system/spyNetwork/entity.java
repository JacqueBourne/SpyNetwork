package spyNetwork;
interface entity{
    public void sendMessage(String message, entity receiver);
    public void receiveMessage(String message, entity sender);
    public String readMessage();
    public boolean checkID(entity requier);
}