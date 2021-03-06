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

package org.forgerock.json.resource.http.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.forgerock.json.resource.ResourceException;

/**
 * Assertion methods for {@link ResourceException}s.
 *
 * <p>To create a new instance of this class, invoke
 * <code>{@link org.forgerock.json.resource.http.Assertions#assertThat(ResourceException) assertThat}(actual)</code>.
 */
@SuppressWarnings("javadoc")
public class ResourceExceptionAssert extends ResponseAssert<ResourceExceptionAssert, ResourceException> {

    public ResourceExceptionAssert(final ResourceException actual) {
        super(actual, ResourceExceptionAssert.class);
    }

    public ResourceExceptionAssert isEqualTo(final ResourceException expected) {
        super.isEqualTo(expected);
        assertThat(actual).isExactlyInstanceOf(expected.getClass());
        assertThat(actual.getMessage()).isEqualTo(expected.getMessage());
        assertThat(actual.getCode()).isEqualTo(expected.getCode());
        assertThat(actual.getReason()).isEqualTo(expected.getReason());
        assertThat(Objects.toString(actual.getDetail())).isEqualTo(Objects.toString(expected.getDetail()));
        return myself;
    }
}
