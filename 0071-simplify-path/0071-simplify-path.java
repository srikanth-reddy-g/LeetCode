class Solution {
    public String simplifyPath(String path) {
        int startIndex=0;
        int endIndex=-1;
        int pathLength=path.length();
        String fileName="";
        Stack<String> files=new Stack<>();
        for(int i=1;i<pathLength;i++){
            if((path.charAt(i)=='/' || i==pathLength-1)) {
                fileName="";
                endIndex=i;
                if (i==pathLength-1 && path.charAt(pathLength-1)!='/') endIndex=i+1;
                fileName=path.substring(startIndex+1,endIndex);
                startIndex=endIndex;
                if(fileName.equals("..") && !files.isEmpty()){
                    files.pop();
                }
                else if (fileName.equals(".")){
                    continue;
                }
                else if(!fileName.equals("..") && !fileName.equals(".") && !fileName.equals("")){
                    files.push(fileName);
                }
            }
        }
        if(files.isEmpty()) return "/";
        String resString="";
        while(!files.isEmpty()){
            resString="/"+files.pop()+resString;
        }
        return resString;
    }
}