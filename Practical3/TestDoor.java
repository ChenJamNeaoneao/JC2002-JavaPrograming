import java.util.*;

class Door
{
    protected boolean isOpen = false;

    public void openDoor(){
        if (isOpen == false){
            System.out.println("Door opened");
            isOpen = true;
            return;
        }
        else {
            System.out.println("Door already open!");
            return;
        }

    }

    public void closeDoor(){
        if (isOpen == false){
            System.out.println("Door already colsed");
            return;
        }
        else {
            System.out.println("Door closed");
            isOpen = false;
            return;
        }    
    }

}

class DoorWithLock extends Door
{
    protected boolean isLock = false;
    @Override
    public void openDoor(){
        if (isOpen == false && isLock == true) {
            System.out.println("Door is locked and cannot be opened!");
            return;
        } 
        else{
            super.openDoor();
        }
        }
    

    public void lockDoor(){
        if(isOpen == true){
            System.out.println("Open door can not be locked");
            return;
        }
        else if (isOpen == false && isLock == true){
            System.out.println("Door already locked");
            return;
        }
        else if (isOpen == false && isLock== false){
            System.out.println("Door locked");
            isLock = true;
            return;
        }
        }
    
    public void unlockDoor(){
        if(isLock == false){
            System.out.println("door is not locked");
            return;
        }
        else{
            System.out.println("door unlocked");
            isLock = false;
            return;
        }
    }
    
}

class DoorWithCodeLock extends DoorWithLock{
    protected int code = 0;
    @Override
    public void lockDoor(){
        if (isOpen == false && isLock == false){
            Scanner scannerr = new Scanner(System.in);
            System.out.println("Enter an integar:");
            int y = scannerr.nextInt();
            code = y;
            isLock = true;
            super.lockDoor();
            return;
        }
        else{
            super.lockDoor();
            return;
        }
    }

    @Override
    public void unlockDoor(){
        if (isLock == true){
            Scanner scannerrr = new Scanner(System.in);
            System.out.println("Enter an integar:");
            int z = scannerrr.nextInt();
            if (z == code){
                isLock = false;
                super.unlockDoor();
                return;
            }
            else{
                System.out.println("Invalid code!");   
                return;
            }
        }
    }
}


public class TestDoor{
    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        DoorWithCodeLock mydoor = new DoorWithCodeLock();

        while(true){
            System.out.println("case 1 opendoor\ncase 2 closedoor\ncase 3 lockdoor\ncase 4 unlockdoor\ncase 5 exit\nchoose a case:");
            int x = scanner.nextInt();

            switch(x){
                case 1:
                    mydoor.openDoor();
                    break;
                case 2:
                    mydoor.closeDoor();
                    break;
                case 3:
                    mydoor.lockDoor();
                    break;
                case 4:
                    mydoor.unlockDoor();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

    }
}