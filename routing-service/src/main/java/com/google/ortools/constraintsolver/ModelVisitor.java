package com.google.ortools.constraintsolver;

public class ModelVisitor extends BaseObject {
   private transient long swigCPtr;

   protected ModelVisitor(long var1, boolean var3) {
      super(mainJNI.ModelVisitor_SWIGUpcast(var1), var3);
      this.swigCPtr = var1;
   }

   protected static long getCPtr(ModelVisitor var0) {
      return var0 == null ? 0L : var0.swigCPtr;
   }

   protected void finalize() {
      this.delete();
   }

   public synchronized void delete() {
      if (this.swigCPtr != 0L) {
         if (this.swigCMemOwn) {
            this.swigCMemOwn = false;
            mainJNI.delete_ModelVisitor(this.swigCPtr);
         }

         this.swigCPtr = 0L;
      }

      super.delete();
   }

   public static String getKAbs() {
      return mainJNI.ModelVisitor_kAbs_get();
   }

   public static String getKAbsEqual() {
      return mainJNI.ModelVisitor_kAbsEqual_get();
   }

   public static String getKAllDifferent() {
      return mainJNI.ModelVisitor_kAllDifferent_get();
   }

   public static String getKAllowedAssignments() {
      return mainJNI.ModelVisitor_kAllowedAssignments_get();
   }

   public static String getKAtMost() {
      return mainJNI.ModelVisitor_kAtMost_get();
   }

   public static String getKIndexOf() {
      return mainJNI.ModelVisitor_kIndexOf_get();
   }

   public static String getKBetween() {
      return mainJNI.ModelVisitor_kBetween_get();
   }

   public static String getKConditionalExpr() {
      return mainJNI.ModelVisitor_kConditionalExpr_get();
   }

   public static String getKCircuit() {
      return mainJNI.ModelVisitor_kCircuit_get();
   }

   public static String getKConvexPiecewise() {
      return mainJNI.ModelVisitor_kConvexPiecewise_get();
   }

   public static String getKCountEqual() {
      return mainJNI.ModelVisitor_kCountEqual_get();
   }

   public static String getKCover() {
      return mainJNI.ModelVisitor_kCover_get();
   }

   public static String getKCumulative() {
      return mainJNI.ModelVisitor_kCumulative_get();
   }

   public static String getKDeviation() {
      return mainJNI.ModelVisitor_kDeviation_get();
   }

   public static String getKDifference() {
      return mainJNI.ModelVisitor_kDifference_get();
   }

   public static String getKDisjunctive() {
      return mainJNI.ModelVisitor_kDisjunctive_get();
   }

   public static String getKDistribute() {
      return mainJNI.ModelVisitor_kDistribute_get();
   }

   public static String getKDivide() {
      return mainJNI.ModelVisitor_kDivide_get();
   }

   public static String getKDurationExpr() {
      return mainJNI.ModelVisitor_kDurationExpr_get();
   }

   public static String getKElement() {
      return mainJNI.ModelVisitor_kElement_get();
   }

   public static String getKElementEqual() {
      return mainJNI.ModelVisitor_kElementEqual_get();
   }

   public static String getKEndExpr() {
      return mainJNI.ModelVisitor_kEndExpr_get();
   }

   public static String getKEquality() {
      return mainJNI.ModelVisitor_kEquality_get();
   }

   public static String getKFalseConstraint() {
      return mainJNI.ModelVisitor_kFalseConstraint_get();
   }

   public static String getKGlobalCardinality() {
      return mainJNI.ModelVisitor_kGlobalCardinality_get();
   }

   public static String getKGreater() {
      return mainJNI.ModelVisitor_kGreater_get();
   }

   public static String getKGreaterOrEqual() {
      return mainJNI.ModelVisitor_kGreaterOrEqual_get();
   }

   public static String getKIntegerVariable() {
      return mainJNI.ModelVisitor_kIntegerVariable_get();
   }

   public static String getKIntervalBinaryRelation() {
      return mainJNI.ModelVisitor_kIntervalBinaryRelation_get();
   }

   public static String getKIntervalDisjunction() {
      return mainJNI.ModelVisitor_kIntervalDisjunction_get();
   }

   public static String getKIntervalUnaryRelation() {
      return mainJNI.ModelVisitor_kIntervalUnaryRelation_get();
   }

   public static String getKIntervalVariable() {
      return mainJNI.ModelVisitor_kIntervalVariable_get();
   }

   public static String getKInversePermutation() {
      return mainJNI.ModelVisitor_kInversePermutation_get();
   }

   public static String getKIsBetween() {
      return mainJNI.ModelVisitor_kIsBetween_get();
   }

   public static String getKIsDifferent() {
      return mainJNI.ModelVisitor_kIsDifferent_get();
   }

   public static String getKIsEqual() {
      return mainJNI.ModelVisitor_kIsEqual_get();
   }

   public static String getKIsGreater() {
      return mainJNI.ModelVisitor_kIsGreater_get();
   }

   public static String getKIsGreaterOrEqual() {
      return mainJNI.ModelVisitor_kIsGreaterOrEqual_get();
   }

   public static String getKIsLess() {
      return mainJNI.ModelVisitor_kIsLess_get();
   }

   public static String getKIsLessOrEqual() {
      return mainJNI.ModelVisitor_kIsLessOrEqual_get();
   }

   public static String getKIsMember() {
      return mainJNI.ModelVisitor_kIsMember_get();
   }

   public static String getKLess() {
      return mainJNI.ModelVisitor_kLess_get();
   }

   public static String getKLessOrEqual() {
      return mainJNI.ModelVisitor_kLessOrEqual_get();
   }

   public static String getKLexLess() {
      return mainJNI.ModelVisitor_kLexLess_get();
   }

   public static String getKLinkExprVar() {
      return mainJNI.ModelVisitor_kLinkExprVar_get();
   }

   public static String getKMapDomain() {
      return mainJNI.ModelVisitor_kMapDomain_get();
   }

   public static String getKMax() {
      return mainJNI.ModelVisitor_kMax_get();
   }

   public static String getKMaxEqual() {
      return mainJNI.ModelVisitor_kMaxEqual_get();
   }

   public static String getKMember() {
      return mainJNI.ModelVisitor_kMember_get();
   }

   public static String getKMin() {
      return mainJNI.ModelVisitor_kMin_get();
   }

   public static String getKMinEqual() {
      return mainJNI.ModelVisitor_kMinEqual_get();
   }

   public static String getKModulo() {
      return mainJNI.ModelVisitor_kModulo_get();
   }

   public static String getKNoCycle() {
      return mainJNI.ModelVisitor_kNoCycle_get();
   }

   public static String getKNonEqual() {
      return mainJNI.ModelVisitor_kNonEqual_get();
   }

   public static String getKNotBetween() {
      return mainJNI.ModelVisitor_kNotBetween_get();
   }

   public static String getKNotMember() {
      return mainJNI.ModelVisitor_kNotMember_get();
   }

   public static String getKNullIntersect() {
      return mainJNI.ModelVisitor_kNullIntersect_get();
   }

   public static String getKOpposite() {
      return mainJNI.ModelVisitor_kOpposite_get();
   }

   public static String getKPack() {
      return mainJNI.ModelVisitor_kPack_get();
   }

   public static String getKPathCumul() {
      return mainJNI.ModelVisitor_kPathCumul_get();
   }

   public static String getKDelayedPathCumul() {
      return mainJNI.ModelVisitor_kDelayedPathCumul_get();
   }

   public static String getKPerformedExpr() {
      return mainJNI.ModelVisitor_kPerformedExpr_get();
   }

   public static String getKPower() {
      return mainJNI.ModelVisitor_kPower_get();
   }

   public static String getKProduct() {
      return mainJNI.ModelVisitor_kProduct_get();
   }

   public static String getKScalProd() {
      return mainJNI.ModelVisitor_kScalProd_get();
   }

   public static String getKScalProdEqual() {
      return mainJNI.ModelVisitor_kScalProdEqual_get();
   }

   public static String getKScalProdGreaterOrEqual() {
      return mainJNI.ModelVisitor_kScalProdGreaterOrEqual_get();
   }

   public static String getKScalProdLessOrEqual() {
      return mainJNI.ModelVisitor_kScalProdLessOrEqual_get();
   }

   public static String getKSemiContinuous() {
      return mainJNI.ModelVisitor_kSemiContinuous_get();
   }

   public static String getKSequenceVariable() {
      return mainJNI.ModelVisitor_kSequenceVariable_get();
   }

   public static String getKSortingConstraint() {
      return mainJNI.ModelVisitor_kSortingConstraint_get();
   }

   public static String getKSquare() {
      return mainJNI.ModelVisitor_kSquare_get();
   }

   public static String getKStartExpr() {
      return mainJNI.ModelVisitor_kStartExpr_get();
   }

   public static String getKSum() {
      return mainJNI.ModelVisitor_kSum_get();
   }

   public static String getKSumEqual() {
      return mainJNI.ModelVisitor_kSumEqual_get();
   }

   public static String getKSumGreaterOrEqual() {
      return mainJNI.ModelVisitor_kSumGreaterOrEqual_get();
   }

   public static String getKSumLessOrEqual() {
      return mainJNI.ModelVisitor_kSumLessOrEqual_get();
   }

   public static String getKTrace() {
      return mainJNI.ModelVisitor_kTrace_get();
   }

   public static String getKTransition() {
      return mainJNI.ModelVisitor_kTransition_get();
   }

   public static String getKTrueConstraint() {
      return mainJNI.ModelVisitor_kTrueConstraint_get();
   }

   public static String getKVarBoundWatcher() {
      return mainJNI.ModelVisitor_kVarBoundWatcher_get();
   }

   public static String getKVarValueWatcher() {
      return mainJNI.ModelVisitor_kVarValueWatcher_get();
   }

   public static String getKCountAssignedItemsExtension() {
      return mainJNI.ModelVisitor_kCountAssignedItemsExtension_get();
   }

   public static String getKCountUsedBinsExtension() {
      return mainJNI.ModelVisitor_kCountUsedBinsExtension_get();
   }

   public static String getKInt64ToBoolExtension() {
      return mainJNI.ModelVisitor_kInt64ToBoolExtension_get();
   }

   public static String getKInt64ToInt64Extension() {
      return mainJNI.ModelVisitor_kInt64ToInt64Extension_get();
   }

   public static String getKObjectiveExtension() {
      return mainJNI.ModelVisitor_kObjectiveExtension_get();
   }

   public static String getKSearchLimitExtension() {
      return mainJNI.ModelVisitor_kSearchLimitExtension_get();
   }

   public static String getKUsageEqualVariableExtension() {
      return mainJNI.ModelVisitor_kUsageEqualVariableExtension_get();
   }

   public static String getKUsageLessConstantExtension() {
      return mainJNI.ModelVisitor_kUsageLessConstantExtension_get();
   }

   public static String getKVariableGroupExtension() {
      return mainJNI.ModelVisitor_kVariableGroupExtension_get();
   }

   public static String getKVariableUsageLessConstantExtension() {
      return mainJNI.ModelVisitor_kVariableUsageLessConstantExtension_get();
   }

   public static String getKWeightedSumOfAssignedEqualVariableExtension() {
      return mainJNI.ModelVisitor_kWeightedSumOfAssignedEqualVariableExtension_get();
   }

   public static String getKActiveArgument() {
      return mainJNI.ModelVisitor_kActiveArgument_get();
   }

   public static String getKAssumePathsArgument() {
      return mainJNI.ModelVisitor_kAssumePathsArgument_get();
   }

   public static String getKBranchesLimitArgument() {
      return mainJNI.ModelVisitor_kBranchesLimitArgument_get();
   }

   public static String getKCapacityArgument() {
      return mainJNI.ModelVisitor_kCapacityArgument_get();
   }

   public static String getKCardsArgument() {
      return mainJNI.ModelVisitor_kCardsArgument_get();
   }

   public static String getKCoefficientsArgument() {
      return mainJNI.ModelVisitor_kCoefficientsArgument_get();
   }

   public static String getKCountArgument() {
      return mainJNI.ModelVisitor_kCountArgument_get();
   }

   public static String getKCumulativeArgument() {
      return mainJNI.ModelVisitor_kCumulativeArgument_get();
   }

   public static String getKCumulsArgument() {
      return mainJNI.ModelVisitor_kCumulsArgument_get();
   }

   public static String getKDemandsArgument() {
      return mainJNI.ModelVisitor_kDemandsArgument_get();
   }

   public static String getKDurationMaxArgument() {
      return mainJNI.ModelVisitor_kDurationMaxArgument_get();
   }

   public static String getKDurationMinArgument() {
      return mainJNI.ModelVisitor_kDurationMinArgument_get();
   }

   public static String getKEarlyCostArgument() {
      return mainJNI.ModelVisitor_kEarlyCostArgument_get();
   }

   public static String getKEarlyDateArgument() {
      return mainJNI.ModelVisitor_kEarlyDateArgument_get();
   }

   public static String getKEndMaxArgument() {
      return mainJNI.ModelVisitor_kEndMaxArgument_get();
   }

   public static String getKEndMinArgument() {
      return mainJNI.ModelVisitor_kEndMinArgument_get();
   }

   public static String getKEndsArgument() {
      return mainJNI.ModelVisitor_kEndsArgument_get();
   }

   public static String getKExpressionArgument() {
      return mainJNI.ModelVisitor_kExpressionArgument_get();
   }

   public static String getKFailuresLimitArgument() {
      return mainJNI.ModelVisitor_kFailuresLimitArgument_get();
   }

   public static String getKFinalStatesArgument() {
      return mainJNI.ModelVisitor_kFinalStatesArgument_get();
   }

   public static String getKFixedChargeArgument() {
      return mainJNI.ModelVisitor_kFixedChargeArgument_get();
   }

   public static String getKIndex2Argument() {
      return mainJNI.ModelVisitor_kIndex2Argument_get();
   }

   public static String getKIndexArgument() {
      return mainJNI.ModelVisitor_kIndexArgument_get();
   }

   public static String getKInitialState() {
      return mainJNI.ModelVisitor_kInitialState_get();
   }

   public static String getKIntervalArgument() {
      return mainJNI.ModelVisitor_kIntervalArgument_get();
   }

   public static String getKIntervalsArgument() {
      return mainJNI.ModelVisitor_kIntervalsArgument_get();
   }

   public static String getKLateCostArgument() {
      return mainJNI.ModelVisitor_kLateCostArgument_get();
   }

   public static String getKLateDateArgument() {
      return mainJNI.ModelVisitor_kLateDateArgument_get();
   }

   public static String getKLeftArgument() {
      return mainJNI.ModelVisitor_kLeftArgument_get();
   }

   public static String getKMaxArgument() {
      return mainJNI.ModelVisitor_kMaxArgument_get();
   }

   public static String getKMaximizeArgument() {
      return mainJNI.ModelVisitor_kMaximizeArgument_get();
   }

   public static String getKMinArgument() {
      return mainJNI.ModelVisitor_kMinArgument_get();
   }

   public static String getKModuloArgument() {
      return mainJNI.ModelVisitor_kModuloArgument_get();
   }

   public static String getKNextsArgument() {
      return mainJNI.ModelVisitor_kNextsArgument_get();
   }

   public static String getKOptionalArgument() {
      return mainJNI.ModelVisitor_kOptionalArgument_get();
   }

   public static String getKPartialArgument() {
      return mainJNI.ModelVisitor_kPartialArgument_get();
   }

   public static String getKPositionXArgument() {
      return mainJNI.ModelVisitor_kPositionXArgument_get();
   }

   public static String getKPositionYArgument() {
      return mainJNI.ModelVisitor_kPositionYArgument_get();
   }

   public static String getKRangeArgument() {
      return mainJNI.ModelVisitor_kRangeArgument_get();
   }

   public static String getKRelationArgument() {
      return mainJNI.ModelVisitor_kRelationArgument_get();
   }

   public static String getKRightArgument() {
      return mainJNI.ModelVisitor_kRightArgument_get();
   }

   public static String getKSequenceArgument() {
      return mainJNI.ModelVisitor_kSequenceArgument_get();
   }

   public static String getKSequencesArgument() {
      return mainJNI.ModelVisitor_kSequencesArgument_get();
   }

   public static String getKSizeArgument() {
      return mainJNI.ModelVisitor_kSizeArgument_get();
   }

   public static String getKSizeXArgument() {
      return mainJNI.ModelVisitor_kSizeXArgument_get();
   }

   public static String getKSizeYArgument() {
      return mainJNI.ModelVisitor_kSizeYArgument_get();
   }

   public static String getKSmartTimeCheckArgument() {
      return mainJNI.ModelVisitor_kSmartTimeCheckArgument_get();
   }

   public static String getKSolutionLimitArgument() {
      return mainJNI.ModelVisitor_kSolutionLimitArgument_get();
   }

   public static String getKStartMaxArgument() {
      return mainJNI.ModelVisitor_kStartMaxArgument_get();
   }

   public static String getKStartMinArgument() {
      return mainJNI.ModelVisitor_kStartMinArgument_get();
   }

   public static String getKStartsArgument() {
      return mainJNI.ModelVisitor_kStartsArgument_get();
   }

   public static String getKStepArgument() {
      return mainJNI.ModelVisitor_kStepArgument_get();
   }

   public static String getKTargetArgument() {
      return mainJNI.ModelVisitor_kTargetArgument_get();
   }

   public static String getKTimeLimitArgument() {
      return mainJNI.ModelVisitor_kTimeLimitArgument_get();
   }

   public static String getKTransitsArgument() {
      return mainJNI.ModelVisitor_kTransitsArgument_get();
   }

   public static String getKTuplesArgument() {
      return mainJNI.ModelVisitor_kTuplesArgument_get();
   }

   public static String getKValueArgument() {
      return mainJNI.ModelVisitor_kValueArgument_get();
   }

   public static String getKValuesArgument() {
      return mainJNI.ModelVisitor_kValuesArgument_get();
   }

   public static String getKVariableArgument() {
      return mainJNI.ModelVisitor_kVariableArgument_get();
   }

   public static String getKVarsArgument() {
      return mainJNI.ModelVisitor_kVarsArgument_get();
   }

   public static String getKEvaluatorArgument() {
      return mainJNI.ModelVisitor_kEvaluatorArgument_get();
   }

   public static String getKMirrorOperation() {
      return mainJNI.ModelVisitor_kMirrorOperation_get();
   }

   public static String getKRelaxedMaxOperation() {
      return mainJNI.ModelVisitor_kRelaxedMaxOperation_get();
   }

   public static String getKRelaxedMinOperation() {
      return mainJNI.ModelVisitor_kRelaxedMinOperation_get();
   }

   public static String getKSumOperation() {
      return mainJNI.ModelVisitor_kSumOperation_get();
   }

   public static String getKDifferenceOperation() {
      return mainJNI.ModelVisitor_kDifferenceOperation_get();
   }

   public static String getKProductOperation() {
      return mainJNI.ModelVisitor_kProductOperation_get();
   }

   public static String getKStartSyncOnStartOperation() {
      return mainJNI.ModelVisitor_kStartSyncOnStartOperation_get();
   }

   public static String getKStartSyncOnEndOperation() {
      return mainJNI.ModelVisitor_kStartSyncOnEndOperation_get();
   }

   public static String getKTraceOperation() {
      return mainJNI.ModelVisitor_kTraceOperation_get();
   }

   public void beginVisitModel(String var1) {
      mainJNI.ModelVisitor_beginVisitModel(this.swigCPtr, this, var1);
   }

   public void endVisitModel(String var1) {
      mainJNI.ModelVisitor_endVisitModel(this.swigCPtr, this, var1);
   }

   public void beginVisitConstraint(String var1, Constraint var2) {
      mainJNI.ModelVisitor_beginVisitConstraint(this.swigCPtr, this, var1, Constraint.getCPtr(var2), var2);
   }

   public void endVisitConstraint(String var1, Constraint var2) {
      mainJNI.ModelVisitor_endVisitConstraint(this.swigCPtr, this, var1, Constraint.getCPtr(var2), var2);
   }

   public void beginVisitExtension(String var1) {
      mainJNI.ModelVisitor_beginVisitExtension(this.swigCPtr, this, var1);
   }

   public void endVisitExtension(String var1) {
      mainJNI.ModelVisitor_endVisitExtension(this.swigCPtr, this, var1);
   }

   public void beginVisitIntegerExpression(String var1, IntExpr var2) {
      mainJNI.ModelVisitor_beginVisitIntegerExpression(this.swigCPtr, this, var1, IntExpr.getCPtr(var2), var2);
   }

   public void endVisitIntegerExpression(String var1, IntExpr var2) {
      mainJNI.ModelVisitor_endVisitIntegerExpression(this.swigCPtr, this, var1, IntExpr.getCPtr(var2), var2);
   }

   public void visitIntegerVariable(IntVar var1, IntExpr var2) {
      mainJNI.ModelVisitor_visitIntegerVariable__SWIG_0(this.swigCPtr, this, IntVar.getCPtr(var1), var1, IntExpr.getCPtr(var2), var2);
   }

   public void visitIntegerVariable(IntVar var1, String var2, long var3, IntVar var5) {
      mainJNI.ModelVisitor_visitIntegerVariable__SWIG_1(this.swigCPtr, this, IntVar.getCPtr(var1), var1, var2, var3, IntVar.getCPtr(var5), var5);
   }

   public void visitIntervalVariable(IntervalVar var1, String var2, long var3, IntervalVar var5) {
      mainJNI.ModelVisitor_visitIntervalVariable(this.swigCPtr, this, IntervalVar.getCPtr(var1), var1, var2, var3, IntervalVar.getCPtr(var5), var5);
   }

   public void visitSequenceVariable(SequenceVar var1) {
      mainJNI.ModelVisitor_visitSequenceVariable(this.swigCPtr, this, SequenceVar.getCPtr(var1), var1);
   }

   public void visitIntegerArgument(String var1, long var2) {
      mainJNI.ModelVisitor_visitIntegerArgument(this.swigCPtr, this, var1, var2);
   }

   public void visitIntegerArrayArgument(String var1, long[] var2) {
      mainJNI.ModelVisitor_visitIntegerArrayArgument(this.swigCPtr, this, var1, var2);
   }

   public void visitIntegerMatrixArgument(String var1, IntTupleSet var2) {
      mainJNI.ModelVisitor_visitIntegerMatrixArgument(this.swigCPtr, this, var1, IntTupleSet.getCPtr(var2), var2);
   }

   public void visitIntegerExpressionArgument(String var1, IntExpr var2) {
      mainJNI.ModelVisitor_visitIntegerExpressionArgument(this.swigCPtr, this, var1, IntExpr.getCPtr(var2), var2);
   }

   public void visitIntegerVariableArrayArgument(String var1, IntVar[] var2) {
      mainJNI.ModelVisitor_visitIntegerVariableArrayArgument(this.swigCPtr, this, var1, var2);
   }

   public void visitIntervalArgument(String var1, IntervalVar var2) {
      mainJNI.ModelVisitor_visitIntervalArgument(this.swigCPtr, this, var1, IntervalVar.getCPtr(var2), var2);
   }

   public void visitIntervalArrayArgument(String var1, IntervalVar[] var2) {
      mainJNI.ModelVisitor_visitIntervalArrayArgument(this.swigCPtr, this, var1, var2);
   }

   public void visitSequenceArgument(String var1, SequenceVar var2) {
      mainJNI.ModelVisitor_visitSequenceArgument(this.swigCPtr, this, var1, SequenceVar.getCPtr(var2), var2);
   }

   public void visitSequenceArrayArgument(String var1, SequenceVar[] var2) {
      mainJNI.ModelVisitor_visitSequenceArrayArgument(this.swigCPtr, this, var1, var2);
   }

   public ModelVisitor() {
      this(mainJNI.new_ModelVisitor(), true);
   }
}
