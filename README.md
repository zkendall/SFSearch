# SFSearch
Shared Folder Search

Problem: Shared drives are a convenient way to share files but too easily can become a cluttered dumping ground.

Solution in two parts:

1. A minimal web app that provides fast searching by maintaining an index of the drive. A number of times I’ve spent unnecessary time trying to find something I knew was on the drive, but wasn’t sure where, and explorer’s search is helplessly slow here. This would improve usability by helping people find what they want, and it would reduce the number of duplicate files as people would be less inclined to add files to the drive if they can find an existing copy.

2. An audit function on the index, that enumerates files that are duplicates, which can be presented to users so they can be encouraged to consolidate duplicates in a “commons” folder, for example. We don’t need who-knows-how-many copies of visual studio, jboss, drivers, etc. floating around in people’s “personal” folders that no one else knows about on a public drive.
