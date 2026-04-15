sample_posts=[
    ["username1","hate you. such a horrible person"],
    ["nani_smiley","heyyy love this post"],
    ["hacker","instead go and sucide"],
    ["unknown","why dont you die"],
    ["dadslilprincess","you look so pretty"],
    ["username1","u disgust me"],
    ["aayasher","waiting for movie"],
    ["hacker","very bad song"],
    ["scuba_cat","scuuba scuuba"],
    ["hacker","hate you soooo much"],
    ["justincase","checkout my reel https://www.instagram.com/p/DWB7Vi1D_DW/?hl=en"]
]

banned_words = ["bad", "toxic", "hate","die","sucide","disgust","horrible"]
cleaned=0
blocked=0
links=[]
cleaned_posts=[]
flags={}

def clean_text(comment):
    contains_banned_word=False
    for word in banned_words:
        if word in comment.lower():
            comment=comment.replace(word,"****")
            contains_banned_word=True
    return comment,contains_banned_word
    

for post in sample_posts:
    user=post[0]
    comment=post[1]
    if user not in flags:
        flags[user]=0

    cleaned_comment,contains_banned_word=clean_text(comment)

    if contains_banned_word:
        blocked+=1
        flags[user]+=1
    else:
        cleaned+=1

    for word in comment.split():
        if word.startswith("http"):
            links.append(word)

    cleaned_posts.append(cleaned_comment)


with open("links.txt", "w") as f:
    for link in links:
        f.write(link + "\n")

print("Links Found:")
print(links)
print("saved into links.txt file")

print(f"Total Posts Screened: {len(sample_posts)} | Cleaned: {cleaned} | Blocked: {blocked}")

print("\nUser Flags:")
for user, count in flags.items():
    print(user, ":", count)

print("\nCleaned Posts:")
for post in cleaned_posts:
    print(post)
