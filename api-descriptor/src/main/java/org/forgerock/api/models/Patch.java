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
 * Copyright 2016 ForgeRock AS.
 */

package org.forgerock.api.models;

import static org.forgerock.api.util.ValidationUtil.isEmpty;

import org.forgerock.api.ApiValidationException;
import org.forgerock.api.enums.PatchOperation;

/**
 * Class that represents the Patch operation type in API descriptor.
 */
public final class Patch extends Operation {

    private final PatchOperation[] operations;
    private final Boolean mvccSupported;

    /**
     * Protected contstructor of the Patch operation.
     *
     * @param builder Patch Builder
     */
    private Patch(Builder builder) {
        super(builder);
        this.mvccSupported = builder.mvccSupported;
        this.operations = builder.operations;

        if (isEmpty(operations) || mvccSupported == null) {
            throw new ApiValidationException("operations and mvccSupported required");
        }
    }

    /**
     * Getter for supported Patch operations.
     *
     * @return Supported Patch operations
     */
    public PatchOperation[] getOperations() {
        return operations;
    }

    /**
     * Informs if MVCC is supported.
     *
     * @return {@code true} if MVCC is supported and {@code false} otherwise
     */
    public boolean isMvccSupported() {
        return mvccSupported;
    }

    /**
     * Creates a new builder for Patch.
     *
     * @return New builder instance
     */
    public static final Builder patch() {
        return new Builder();
    }

    /**
     * Allocates the Patch operation type to the given Resource Builder.
     *
     * @param resourceBuilder - Resource Builder to add the operation
     */
    @Override
    protected void allocateToResource(Resource.Builder resourceBuilder) {
        resourceBuilder.patch(this);
    }

    /**
     * Builds a Patch object from the data stored in the annotation.
     * @param patch Patch annotation that holds the data
     * @param descriptor The root descriptor to add definitions to.
     * @param relativeType The type relative to which schema resources should be resolved.
     * @return Patch instance
     */
    public static Patch fromAnnotation(org.forgerock.api.annotations.Patch patch, ApiDescription descriptor,
            Class<?> relativeType) {
        return patch()
                .detailsFromAnnotation(patch.operationDescription(), descriptor, relativeType)
                .mvccSupported(patch.mvccSupported())
                .operations(patch.operations())
                .build();
    }


    /**
     * Builder to help construct the Patch.
     */
    public static final class Builder extends Operation.Builder<Builder> {

        private PatchOperation[] operations;
        private Boolean mvccSupported;

        private Builder() {
            super();
        }

        /**
         * Setter for supported Patch-operations.
         *
         * @param operations Supported Patch-operations
         * @return Builder
         */
        public Builder operations(PatchOperation... operations) {
            this.operations = operations;
            return this;
        }

        /**
         * Setter for MVCC-supported flag.
         *
         * @param mvccSupported Whether this resource supports MVCC
         * @return Builder
         */
        public Builder mvccSupported(boolean mvccSupported) {
            this.mvccSupported = mvccSupported;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds the Patch instance.
         *
         * @return Patch instance
         */
        public Patch build() {
            return new Patch(this);
        }
    }

}