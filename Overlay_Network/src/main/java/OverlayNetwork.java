import lk.ac.mrt.cse.distributed_system.bootsrtap_server.BootstrapServer;
import lk.ac.mrt.cse.distributed_system.node.Node;

public class OverlayNetwork {

    public static void main(String args[]) {

        if (args.length != 1) {
            System.out.println("Require one parameter with value 1 or 2 (1: master node, 2: peer node)");
        } else {
            String mode = args[0];
            if (mode.equals("1"))
            {
                System.out.println("Selected Node Type: Master Node");
                BootstrapServer server = new BootstrapServer();
                server.startServer();
            }
            else if (mode.equals("2"))
            {
                System.out.println("Selected Node Type: Peer Node");
                Node node = new Node();
                node.initiateNode();
            }
            else{
                System.out.println("RParameter value should be value 1 or 2 (1: master node, 2: peer node)");
            }
        }
    }
}

