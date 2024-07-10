class Solution {
    public int minOperations(String[] logs) {
        int res=0;
        Stack <String> folderStack=new Stack<>();
        for(int i=0;i<logs.length;i++){
            if(logs[i].equals("../") && !folderStack.isEmpty()){
                folderStack.pop();
                res--;
            }
            else if(logs[i].equals("./")) continue;
            else if(!logs[i].equals("../") && !logs[i].equals("./")){
                folderStack.push(logs[i]);
                res++;
            }
        }
        return res;
    }
}