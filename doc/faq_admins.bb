[size=large][b]The Red Matrix FAQ[/b][/size]

[ul]
[*][b]Is there a way to change the Admin account?[/b]
[*][b]Is there a way to have multiple administrators?[/b]
Yes, but it's a bit messy at the moment as it is not yet exposed in the UI.  To make an account an administrative account, 
one needs to add 4096 to the account_roles entry in the account table of the database.  Likewise, to remove administrative permissions, 
one must subtract 4096 from the account roles.

[*][b]I can log in, but there are no posts or webpages[/b]

Most likely, your item table has crashed.  Run the MySQL command [code]repair table item;[/code]

[*][b]Login doesn't work, immediately after login, the page reloads and I'm logged out[/b]

Most likely, your session table has crashed.  Run the MySQL command [code]repair table session;[/code]

[*][b]When I switch theme, I sometimes get elements of one theme superimposed on top of the other[/b]

a) store/[data]/smarty3 isn't writeable by the webserver.  Make it so.

b) You're using Midori, or with certain themes, Konqueror in KHTML mode.  

[b]My network tab won't load, it appears to be caused by a photo or video[/b]

Your PHP memory limit is too low.  Increase the size of the memory_limit directive in your php.ini 

Contrary to popular belief, the number of users on a hub doesn't make any difference to the required memory limit, rather, the content
of an individuals matrix counts.  Streams with lots of photos and video require more memory than streams with lots of text.

[*] [b]I have no communication with anybody[/b]

You're listening on port 443, but do not have a valid SSL certificate.  Note this applies even if your baseurl is http.
Don't listen on port 443 if you cannot use it.  It is strongly recommended to solve this problem by installing a browser
valid SSL certificate rather than disabling port 443.

[*]
[b]What do I need to do when moving my hub to a different server[/b]

1) Git clone on the new server.  Repeat the process for any custom themes, and addons.
2) Rsync .htconfig.php
3) Rsync everything in store/
4) Rsync everything in mod/site/ and view/site (these will only exist if you have custom modules)
5) Dump and restore DB.

[*]
[b]How do I reinstall an existing hub on the same server?[/b]

1) [code]git reset --hard HEAD[/code] will reset all files to their upstream defaults.  This will not reset any local files that do not also exist upstream.  Eg, if you have local changes to mod/channel.php, this will reset them - but will not reset any changes in mod/site/channel.php
2) If you absolutely must reinstall - for example, if you need to upgrade operating system - follow the steps for moving to a different server, but instead of using rsync, backup and restore some other way.

Do not reinstall a hub with a fresh database and fresh .htconfig.php unless as a very last resort.  Creating a temporary account and ask for help via a support channel for non-trivial reinstalls is preferable to reinstalling fresh.

[*]
[b]How do I set the default homepage for logged out viewers?[/b]

Use the custom_home addon available in the main addons repository.

[/ul]

#include doc/macros/main_footer.bb;
