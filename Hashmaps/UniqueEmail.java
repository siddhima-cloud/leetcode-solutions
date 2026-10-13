class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmail= new HashSet<>();

        for(String email: emails)
        {
            String d_name="";
            String clearEmail="";
            for(int i=0;i<email.length();i++)
            {
                if(email.charAt(i)=='.')
                {
                    continue;
                }
                else if(email.charAt(i)=='+'||email.charAt(i)=='@')
                {
                    break;
                }
                clearEmail+= email.charAt(i);
            }

            for(int i=email.length()-1;i>=0;i--)
            {
                d_name =email.charAt(i)+d_name;
                if(email.charAt(i)=='@')
                {
                    break;
                }
            }
            clearEmail+=d_name;
            uniqueEmail.add(clearEmail);
        }
        return uniqueEmail.size();
    }
}