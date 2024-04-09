import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String,Folder> folderMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0 ;i<N+M; i++){
            st = new StringTokenizer(br.readLine()," ");
            String folderName = st.nextToken();
            String subFolder = st.nextToken();
            int isFolder = Integer.parseInt(st.nextToken());

            Folder folder = folderMap.get(folderName);
            if(folder==null){
                folder = new Folder();
                folderMap.put(folderName,folder);
            }

            if(isFolder == 1){
                folder.folderList.add(subFolder);
                if(folderMap.get(subFolder) == null)
                    folderMap.put(subFolder,new Folder());
            }
            else {//파일일때
                folder.files.add(subFolder);
            }
        }
        int Q = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < Q ; i ++){
            String[] s = br.readLine().split("/");
            String folderName = s[s.length-1];
            Set<String> fileType = new HashSet<>();
            int cnt = doQuery(folderName,fileType);
            System.out.println(fileType.size() + " "+cnt);
    }
}
    private static int doQuery(String folderName, Set<String> fileType) {
        Folder folder = folderMap.get(folderName);
        int cnt = 0;
        for (String s : folder.folderList) {
            cnt+=doQuery(s,fileType);
        }
        fileType.addAll(folder.files);
        cnt += folder.files.size();
        return cnt;
    }
}



    class Folder{
    Set<String> folderList = new HashSet<>();
    Set<String> files = new HashSet<>();
}
