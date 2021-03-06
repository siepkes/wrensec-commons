/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2015 ForgeRock AS.
 */

package org.forgerock.selfservice.stages;

/**
 * Constants class for defining fields for common state shared across stages.
 *
 * @since 0.1.0
 */
public final class CommonStateFields {

    private CommonStateFields() {
        throw new UnsupportedOperationException();
    }

    /**
     * The userId field.
     */
    public static final String USER_ID_FIELD = "userId";

    /**
     * The email address field.
     */
    public static final String EMAIL_FIELD = "mail";

    /**
     * The user field. This would be a Json object with properties such as name, kba etc.
     */
    public static final String USER_FIELD = "user";

    /**
     * The username field.
     */
    public static final String USERNAME_FIELD = "username";

}
