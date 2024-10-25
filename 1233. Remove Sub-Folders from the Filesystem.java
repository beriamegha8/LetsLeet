class Solution {
    public List<String> removeSubfolders(String[] folder) {
        //lexicographically sorting
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String prev = "";  // Keep track of the previous added folder
        for (String f : folder) {
            // If the current folder is not a subfolder of the previous one, add it to the result
            if (prev.isEmpty() || !f.startsWith(prev + "/")) {
                result.add(f);
                prev = f;  // Update the previous folder to the current one
            }
        }
        return result;
    }
}
