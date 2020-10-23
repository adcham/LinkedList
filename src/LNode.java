public class LNode {
    public int data;
    public LNode nextNode;

    public LNode(){
        this.data = 0;
        this.nextNode = null;
    }

    public LNode(int data) {
        this.data = data;
        this.nextNode = null;
    }

    public void AddItems(int value) {
        if (this.nextNode == null)
            this.nextNode = new LNode(value);
        else
            this.nextNode.AddItems(value);
    }

    public int GetNoOfItemsRecursion() {
        if (this.nextNode == null)
            return 1;
        else {
            return 1 + this.nextNode.GetNoOfItemsRecursion();
        }
    }

    public int GetItemByIndexRecursion(int counter) {
        if (counter == 1)
            return this.data;
        else
            return this.nextNode.GetItemByIndexRecursion(counter-1);
    }

    public LNode GetObject(int counter) {
        if (counter == 0)
            return this;
        else
            return this.nextNode.GetObject(counter-1);
    }

    public String ListAllItemsRecursion(String previousItems) {
        StringBuilder itemList = new StringBuilder();
        itemList.append(previousItems);

        if (this.nextNode == null) {
            itemList.append(this.data);

            return itemList.toString();
        }
        else {
            itemList.append(this.data);
            //adds formatting only if going to add new value
            itemList.append(", ");

            return this.nextNode.ListAllItemsRecursion(itemList.toString());
        }

    }
}
