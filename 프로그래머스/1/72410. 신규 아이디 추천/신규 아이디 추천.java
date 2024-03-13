class Solution {
        public String solution(String new_id) {
            String answer = "";

            answer = makeIDwithUpper(new_id);
            answer = removeSpecificChar(answer);
            answer = makeNDotToOneDot(answer);
            answer = removeStartAndEndDot(answer);
            answer = step5(answer);
            answer = step6(answer);
            answer = step7(answer);

            return answer;
        }
            String makeIDwithUpper(String id){
            return id.toLowerCase();
        }
        String removeSpecificChar(String id){
            return id.replaceAll("[^a-z0-9-_\\.]","");
        }
        String makeNDotToOneDot(String id){
            return id.replaceAll("\\.{2,}",".");
        }
        String removeStartAndEndDot(String id){
            char[] crr = id.toCharArray();
            if(id.isEmpty())
                return id;
            StringBuilder sb = new StringBuilder();
            int i = -1;
            for (char c : crr) {
                i++;
                if ((i == 0 || i == crr.length-1) && c == '.') {
                    continue;
                }
                sb.append(c);
            }
            return sb.toString();
        }
        String step5(String id){
            if (id.isEmpty()) {
                return "a";
            }
            else return id;
        }
        String step6(String id){
            if(id.length()<=15){
                if(id.charAt(id.length()-1) == '.'){
                    return id.substring(0,id.length()-1);
                }
                return id;
            }
            if (id.charAt(14) == '.') {
                return id.substring(0,14);
            }
            return id.substring(0,15);
        }
        String step7(String id){
            if(!id.isEmpty() && id.length()<=2){
                String s = String.valueOf(id.charAt(id.length()-1));
                for(int i = id.length() ; i<3; i++){
                    id+=s;
                }
            }
            return id;
        }
}