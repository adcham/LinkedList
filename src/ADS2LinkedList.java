public class ADS2LinkedList {

    private LNode rootNode;

    public ADS2LinkedList()
    {
        rootNode = null;
    }

    //-----------------
    //recursive methods
    //-----------------

    public int GetNoOfItemsRecursion (){
        if (rootNode == null)
            return 0;
        else
            return rootNode.GetNoOfItemsRecursion();
    }

    public int GetItemByIndexRecursion(int index)
    {
        try {
            if (index == 0)
                return rootNode.data;
            else
                return rootNode.GetItemByIndexRecursion(index);
        } catch (Exception e) {
            System.out.println("Could not find value at " + index);

            return -1;
        }

    }

    public void AddItem(int value)
    {
        if (rootNode == null)
            rootNode = new LNode(value);
        else
            rootNode.AddItems(value);
    }

    public void InsertItem(int index, int value)
    {
        if (index >= GetNoOfItemsRecursion())
            AddItem(value);

        if (index <= 0){
            LNode temp = new LNode(value);
            temp.nextNode = rootNode;
            rootNode = temp;
        }

        if (index > 0 && index < GetNoOfItemsRecursion())
        {
            LNode tracker = rootNode.GetObject(index);
            LNode temp = tracker.nextNode;

            LNode insertedNode = new LNode(value);
            tracker.nextNode = insertedNode;
            insertedNode.nextNode = temp;
        }
    }

    public void DeleteItem(int index)
    {
        if (GetNoOfItemsRecursion() < index)
            System.out.println("Index is out of bounds, data structure remains unchanged");

        if (index == 0) {
            LNode tracker = rootNode.GetObject(1);
            rootNode.nextNode = null;
            rootNode = tracker;
        }

        if (index > 0 && index < GetNoOfItemsRecursion())
            rootNode.GetObject(index-1).nextNode = rootNode.GetObject(index+1);
    }

    public String ListAllItemsRecursion(){
        //have to provide a string to recursive function here, not sure if there is a better way to do this
        return rootNode.ListAllItemsRecursion("");
    }

    //-----------------
    //iterative methods
    //-----------------

    public int GetItemByIndex(int index)
    {
        if (index == 0)
            return rootNode.data;
        else {
            int indexCounter = 1;

            try {
                for (LNode n = rootNode; indexCounter <= index; n = n.nextNode) {
                    if (index == indexCounter)
                        return n.data;
                    indexCounter++;
                }
            } catch (Exception ex) {
                System.out.println("Could not find value at " + index);

                return -1;
            }
        }

        return -1;
    }

    public int GetNoOfItems()
    {
        if (rootNode == null)
            return 0;

        int counter = 1;

        for (LNode n = rootNode; n.nextNode != null; n = n.nextNode)
            counter++;

        return counter;
    }

    public String ListAllItems(){
        StringBuilder itemList = new StringBuilder();

        for (int i = 0; i < GetNoOfItemsRecursion(); i++)
        {
            itemList.append(+rootNode.GetObject(i).data);

            if (rootNode.GetObject(i).nextNode != null)
                itemList.append(", ");
        }

        return itemList.toString();
    }

}
