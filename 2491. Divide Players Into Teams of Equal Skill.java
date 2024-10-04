class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        long sumChemistry = 0;
        int targetSkill = skill[0] + skill[n - 1];
        for (int i = 0; i < n / 2; i++) {
            int teamSkill = skill[i] + skill[n - 1 - i];
            if (teamSkill != targetSkill) {
                return -1;
            }
            sumChemistry += (long) skill[i] * skill[n - 1 - i];
        }
        return sumChemistry;
    }
}
