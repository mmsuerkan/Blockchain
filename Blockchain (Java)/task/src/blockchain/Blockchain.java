package blockchain;

import java.util.LinkedList;

public class Blockchain {

    LinkedList<Block> blockchain = new LinkedList<>();

    void generateGenesisBlock() {
        Block genesisBlock = new Block(1,"0");
        blockchain.add(genesisBlock);
    }


    void addBlock(int numberOfBlock) {
        generateGenesisBlock();

        for (int i = 1; i < numberOfBlock; i++) {
            Block block = new Block(i+1,blockchain.getLast().getHash());
            blockchain.add(block);
        }

    }

    boolean isChainValid() {

        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    void printChain() {
        for (Block block : blockchain) {
            System.out.println(block);
        }
    }


}
