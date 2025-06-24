# OPSC6311-Final-App
ByteBalance - Budget Tracker App

📱 ByteBalance App – Final Report
1. Purpose of the App
The ByteBalance app is a personal budget tracker designed to help users — particularly students and young adults — manage their finances effectively. Its primary objective is to promote financial responsibility through features that allow users to:

Record and monitor daily expenses

Set and track monthly budget goals

View categorized summaries of spending

Earn daily login rewards via gamification

The app is built for Android and stores data locally using SQLite. It ensures that each user’s data — including expenses, budget goals, and login rewards — is kept separate and secure.

2. Design Considerations
During the development of ByteBalance, we followed usability principles to guide the interface and user experience:

a) Effectiveness
The app offers core financial tools such as budget goal-setting, expense tracking, and summaries.

b) Efficiency
Users can add an expense or set a budget goal in just a few taps.

c) Satisfaction
Clean and modern UI with a green-themed palette for visual comfort.

Rewards and clear feedback enhance user enjoyment.

d) Learnability
Simple navigation, clear labels, and consistent icons ensure ease of use.

3. Utilization of GitHub and GitHub Actions
GitHub Usage
Version Control: All source code was pushed to GitHub to manage versions and history.

Branching: Feature-specific branches (e.g. delete-expense, budget-goal-feature) were created to isolate development and simplify testing.

Collaboration: Group members used commits and pull requests for clear communication and tracking of contributions.

GitHub Actions
We integrated GitHub Actions to enable Continuous Integration, automatically performing:

Code format checks

Build validation for Android

Linting and error detection

This helped maintain a stable and reliable codebase.

4. Independently Implemented Features
✅ Feature 1: Logout Function
A logout button was added to the dashboard:

Ends the current user’s session

Returns to the login screen

Disables the ability to go back to the dashboard with the back button

Why we added it:
To support multiple users on one device and maintain personal data privacy.

✅ Feature 2: Delete Expense Function
Each expense entry in the “View Expenses” screen now includes a delete button:

Clicking it prompts a confirmation dialog

Once confirmed, the entry is removed from the SQLite database

The UI refreshes to reflect the changes

Why we added it:
To give users better control over their data and the ability to remove incorrect or outdated entries.

5. App Icon and Image Assets
We also designed and integrated a custom app icon to reflect ByteBalance’s identity and make it visually recognizable on Android devices. Additionally:

Image assets were included for UI enhancement, such as:

Uploading photos for receipts or proofs of expense

Displaying uploaded images inside the expense cards

Maintaining a consistent and modern aesthetic using scalable icons and logos

These additions significantly improved the visual identity and professional appearance of the app.

6. Conclusion
The ByteBalance app is a complete, offline-capable budget tracking solution designed with usability, reliability, and personal finance in mind. By combining local data storage with helpful features and a polished UI, we created a tool that students can use to better manage their financial habits.

Features like Logout, Delete Expense, App Icon, and Gamified Login Rewards were implemented manually to go beyond basic requirements. The use of GitHub and GitHub Actions ensured smooth collaboration, quality control, and continuous testing.

We are confident this project demonstrates both practical development skills and thoughtful design principles. In future versions, we aim to integrate payment systems and cloud backup.

YouTube Link: https://youtu.be/mJdsQFaduYc?feature=shared
