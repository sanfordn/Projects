/**
 * Java Settlers - An online multiplayer version of the game Settlers of Catan
 * Copyright (C) 2003  Robert S. Thomas <thomas@infolab.northwestern.edu>
 * This file copyright (C) 2009,2016 Jeremy D Monin <jeremy@nand.net>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * The maintainer of this program can be reached at jsettlers@nand.net
 **/
package soc.client;

import java.awt.Frame;

// TODO consider callback option; ActionListener

/**
 * This is a generic dialog to popup a message to the player, with one button.
 * Asynchronously returns, and then the dialog sticks around not affecting
 * anything, until the user dismisses it.  At that point it only disappears.
 * A callback can be added later if needed.
 *
 * @author Jeremy D Monin <jeremy@nand.net>
 * @since 1.1.06
 */
class NotifyDialog extends AskDialog
{
    /**
     * Creates and shows a new NotifyDialog.
     *
     * @param cli      Player client interface
     * @param gamePI   Current game's player interface, or another Frame for our parent window,
     *                 or null to look for cli's Frame as parent
     * @param promptText  Prompt text appearing above button; also used for the dialog title.
     *                 If multiple lines, first line is title; if begins with \n, title is "JSettlers".
     * @param btnText  Button text, or null for "OK"
     * @param hasDefault  Button is default (responds to Enter)
     * @throws IllegalArgumentException If cli, promptText, or btnText is null
     */
    public static void createAndShow(SOCPlayerClient cli, Frame gamePI, String promptText, String btnText, boolean hasDefault)
        throws IllegalArgumentException
    {
        if (btnText == null)
            btnText = "OK";
        NotifyDialog nd = new NotifyDialog
	    (cli, gamePI, promptText, btnText, hasDefault);
        nd.show();      
    }

    /**
     * Creates a new NotifyDialog.
     *
     * @param cli      Player client interface
     * @param gamePI   Current game's player interface, or another Frame for our parent window,
     *                 or null to look for cli's Frame as parent
     * @param promptText  Prompt text appearing above button; also used for the dialog title.
     *                 If multiple lines, first line is title; if begins with \n, title is "JSettlers".
     * @param btnText  Button text
     * @param hasDefault  Button is default (responds to Enter)
     * @throws IllegalArgumentException If cli or btnText is null
     */
    protected NotifyDialog(SOCPlayerClient cli, Frame gamePI, String promptText, String btnText, boolean hasDefault)
    {
        super(cli,
       	     ((gamePI != null)
       	          ? gamePI
       	          : getParentFrame(cli)),
        	promptText, promptText,
            btnText, hasDefault);
    }

    /**
     * React to the button. (AskDialog will dismiss the dialog)
     */
    public void button1Chosen()
    {
        // Nothing to do (AskDialog will dismiss it)
    }

    /**
     * Required stub; there is no button 2 in this dialog.
     */
    public void button2Chosen() { }

    /**
     * React to the dialog window closed by user. (Nothing to do)
     */
    public void windowCloseChosen() { }

}