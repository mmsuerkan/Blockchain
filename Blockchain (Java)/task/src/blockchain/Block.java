package blockchain;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Block {


    int id = 0;
    long timeStamp;
    String hash;
    String previousHash;

    public Block(Integer id,String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
        this.id = id;
    }
    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash +
                        timeStamp +
                        id
        );
    }

    @Override
    public String toString() {
        return "Block:" + "\n" +
                "Id: " + id + "\n" +
                "Timestamp: " + timeStamp + "\n" +
                "Hash of the previous block: " + "\n" + previousHash + "\n" +
                "Hash of the block: " + "\n" + hash + "\n";
    }
}
