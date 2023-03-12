package blockchain;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.addBlock(5);
        if(blockchain.isChainValid()){
            blockchain.printChain();
        }
    }
}
